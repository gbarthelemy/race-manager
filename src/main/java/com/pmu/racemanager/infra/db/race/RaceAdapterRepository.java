package com.pmu.racemanager.infra.db.race;

import com.pmu.racemanager.domain.race.Race;
import com.pmu.racemanager.domain.race.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RaceAdapterRepository implements RaceRepository {

    private final RaceMysqlRepository mysqlRepository;

    @Override
    public Race create(Race race) {
        RaceEntity savedRace = mysqlRepository.save(RaceEntity.fromDomain(race));
        return savedRace.toDomain();
    }
}
