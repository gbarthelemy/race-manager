package com.pmu.racemanager.domain.race;

import java.time.LocalDate;
import java.util.Set;

public record Race(
        LocalDate date,
        int number,
        String name,
        Set<Starter> starters
) {
}
