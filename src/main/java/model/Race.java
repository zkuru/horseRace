package model;

import lombok.Data;

import java.util.Collection;

@Data
public class Race {
    private final int distance;
    private final int numberOfHorses;

    Collection<Horse> horsesInRace;
}
