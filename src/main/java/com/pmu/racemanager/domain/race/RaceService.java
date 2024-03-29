package com.pmu.racemanager.domain.race;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class RaceService {

    private final RaceRepository repository;
    private final RaceProducer producer;

    public Race create(Race race) {
        validate(race);

        var savedRace = repository.create(race);

        producer.publish(savedRace);

        return savedRace;
    }

    private void validate(Race race) {
        //TODO throw exception if race is not valid

        if (race.starters().size() < 3) {
            throw new InvalidRaceException("Race should have at least 3 starters");
        }

        if (hasDuplicate(race.starters())) {
            //TODO could be improved by finding what are the duplicates
            throw new InvalidRaceException("Duplicate starter");
        }

        if (isNotIncrementalOrHasBlank(race.starters())) {
            throw new InvalidRaceException("Starters number are invalid");
        }
    }

    private boolean isNotIncrementalOrHasBlank(Set<Starter> starters) {
        AtomicInteger expectedNumber = new AtomicInteger(1);
        return starters.stream()
                .map(Starter::number)
                .allMatch(number -> number == expectedNumber.getAndIncrement());
    }

    private static boolean hasDuplicate(Set<Starter> starters) {
        return starters.stream().map(Starter::name).distinct().count() == starters.size();
    }
}
