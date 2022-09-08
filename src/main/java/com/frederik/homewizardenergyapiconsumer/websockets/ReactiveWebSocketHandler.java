package com.frederik.homewizardenergyapiconsumer.websockets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frederik.homewizardenergyapiconsumer.repository.MeasurementRepo;
import com.frederik.homewizardenergyapiconsumer.utils.ModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component("ReactiveWebSocketHandler")
@Slf4j
@RequiredArgsConstructor
public class ReactiveWebSocketHandler implements WebSocketHandler {

    private static final ObjectMapper json = new ObjectMapper();

    private final MeasurementRepo measurementRepo;

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        Flux<WebSocketMessage> messageFlux = Flux.interval(Duration.ofSeconds(1))
                .flatMap(tick -> measurementRepo.findFirstByOrderByMeasuredTimeDesc())
                .map(ModelMapper::entityToDto)
                .map(measurementDto -> {
                    try {
                        return json.writeValueAsString(measurementDto);
                    } catch (JsonProcessingException e) {
                        log.error("Error while serializing measurementDto", e);
                        return "";
                    }
                })
                .map(session::textMessage);

        return session.send(
                        messageFlux
                                )
                .and(session.receive()
                        .map(WebSocketMessage::getPayloadAsText).log());
    }
}