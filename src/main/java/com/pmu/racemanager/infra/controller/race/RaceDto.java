package com.pmu.racemanager.infra.controller.race;

import com.pmu.racemanager.domain.race.Race;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record RaceDto(
        LocalDate date,
        Integer number,
        String name,
        Set<StarterDto> starters
) {
    public static RaceDto fromDomain(Race domain) {
        return new RaceDto(domain.date(),
                domain.number(),
                domain.name(),
                domain.starters().stream()
                        .map(StarterDto::fromDomain)
                        .collect(Collectors.toSet()));
    }

    public Race toDomain() {
        return new Race(date, number, name, starters()
                .stream()
                .map(StarterDto::toDomain)
                .collect(Collectors.toSet())
        );
    }
}
