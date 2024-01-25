package com.pmu.racemanager.infra.db.race;

import com.pmu.racemanager.domain.race.Starter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "starter")
@NoArgsConstructor
@AllArgsConstructor
public class StarterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String name;

    public StarterEntity(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static StarterEntity fromDomain(Starter starter) {
        return new StarterEntity(starter.number(), starter.name());
    }

    public Starter toDomain() {
        return new Starter(number, name);
    }
}
