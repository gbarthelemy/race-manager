package com.pmu.racemanager.infra.controller.race;

import com.pmu.racemanager.domain.race.Starter;

public record StarterDto(
        int number,
        String name
) {
    public Starter toDomain() {
        return new Starter(number, name);
    }

    public static StarterDto fromDomain(Starter domain) {
        return new StarterDto(domain.number(), domain.name());
    }
}
