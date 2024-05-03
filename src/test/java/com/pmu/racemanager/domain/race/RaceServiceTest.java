package com.pmu.racemanager.domain.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class RaceServiceTest {

    @InjectMocks
    private RaceService sut;
    @Mock
    private RaceRepository repository;
    @Mock
    private RaceProducer producer;

    //TODO add missing test
    //TODO parameterized test on invalid cases
    @Test
    void create_should_throw_exception_in_case_of_less_than_3_starters() {
        //given
        var race = new Race(LocalDate.now(), 1, "course 1", Set.of(
                new Starter(1, "1"),
                new Starter(2, "2")
        ));

        //when
        //then
        Assertions.assertThatThrownBy(() -> sut.create(race))
                .hasMessage("Race should have at least 3 starters")
                .isInstanceOf(InvalidRaceException.class);
    }

    @Test
    void create_should_throw_exception_in_case_of_duplicate_starter() {
        //given
        var race = new Race(LocalDate.now(), 1, "course 1", Set.of(
                new Starter(1, "duplicate"),
                new Starter(2, "duplicate"),
                new Starter(3, "3")
        ));

        //when
        //then
        Assertions.assertThatThrownBy(() -> sut.create(race))
                .hasMessage("Duplicate starter")
                .isInstanceOf(InvalidRaceException.class);
    }

    @Test
    void create_should_throw_exception_in_case_of_missing_number() {
        //given
        var race = new Race(LocalDate.now(), 1, "course 1", Set.of(
                new Starter(1, "1"),
                new Starter(3, "3"),
                new Starter(4, "4")
        ));

        //when
        //then
        Assertions.assertThatThrownBy(() -> sut.create(race))
                .hasMessage("Starters number are invalid")
                .isInstanceOf(InvalidRaceException.class);
    }
}
