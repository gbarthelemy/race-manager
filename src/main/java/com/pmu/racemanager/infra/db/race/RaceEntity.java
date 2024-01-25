package com.pmu.racemanager.infra.db.race;

import com.pmu.racemanager.domain.race.Race;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity(name = "race")
@NoArgsConstructor
@AllArgsConstructor
public class RaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private int number;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "race_id")
    private Set<StarterEntity> starters;

    public static RaceEntity fromDomain(Race race) {
        return new RaceEntity(race.date(), race.number(), race.name(), race.starters()
                .stream()
                .map(StarterEntity::fromDomain)
                .collect(Collectors.toSet()));
    }

    public RaceEntity(LocalDate date, int number, String name, Set<StarterEntity> starters) {
        this.date = date;
        this.number = number;
        this.name = name;
        this.starters = starters;
    }

    public Race toDomain() {
        return new Race(date, number, name, starters.stream().map(StarterEntity::toDomain).collect(Collectors.toSet()));
    }
}
