package com.pmu.racemanager.domain.race;

//TODO create a handler to map this exception to HTTP 400 response code
public class InvalidRaceException extends RuntimeException {

    public InvalidRaceException(String message) {
        super(message);
    }
}
