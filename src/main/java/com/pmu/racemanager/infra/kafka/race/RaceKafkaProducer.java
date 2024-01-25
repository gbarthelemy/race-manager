package com.pmu.racemanager.infra.kafka.race;

import com.pmu.racemanager.domain.race.Race;
import com.pmu.racemanager.domain.race.RaceProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RaceKafkaProducer implements RaceProducer {

    private static final String RACE_TOPIC_NAME = "race";

    private final KafkaTemplate<String, RaceKafkaDto> kafkaTemplate;

    @Override
    public void publish(Race domain) {
        var raceKafkaDto = new RaceKafkaDto(); //TODO implement RaceKafkaDto and mapper

        kafkaTemplate.send(RACE_TOPIC_NAME, raceKafkaDto);
    }
}
