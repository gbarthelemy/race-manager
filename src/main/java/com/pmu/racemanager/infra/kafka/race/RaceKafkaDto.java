package com.pmu.racemanager.infra.kafka.race;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaceKafkaDto {

    //TODO implement fields
    @JsonProperty("todo")
    private String todo;
}
