package com.pmu.racemanager.infra.controller.race;

import com.pmu.racemanager.domain.race.RaceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/races")
@RequiredArgsConstructor
public class RaceController {

    private final RaceService service;

    @PostMapping
    public RaceDto post(@Valid @RequestBody RaceDto dto) {
        var createdRace = service.create(dto.toDomain());

        return RaceDto.fromDomain(createdRace);
    }
}
