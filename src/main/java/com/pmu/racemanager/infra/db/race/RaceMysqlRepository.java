package com.pmu.racemanager.infra.db.race;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceMysqlRepository extends JpaRepository<RaceEntity, Long> {
}
