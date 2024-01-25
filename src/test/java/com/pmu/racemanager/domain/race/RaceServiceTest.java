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
    void create_should_throw_exception_in_case_of_invalid_input() {
        //given
        var race = new Race(LocalDate.now(), 1, "course 1", Set.of(
                new Starter(1, "1"),
                new Starter(3, "3")
        ));

        //when
        //then
        Assertions.assertThatThrownBy(() -> sut.create(race))
                .isInstanceOf(InvalidRaceException.class);

    }
}
