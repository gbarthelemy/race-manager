package com.pmu.racemanager.infra.controller.race;

import com.pmu.racemanager.domain.race.Race;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record RaceDto(
        @NotNull LocalDate date,
        @NotNull Integer number,
        @NotEmpty String name,
        @NotEmpty @Size(min = 3) Set<StarterDto> starters
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
