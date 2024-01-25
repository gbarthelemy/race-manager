package com.pmu.racemanager.domain.race;

public interface RaceProducer {
    void publish(Race domain);
}
