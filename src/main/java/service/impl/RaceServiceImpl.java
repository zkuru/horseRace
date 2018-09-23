package service.impl;

import lombok.Data;
import model.Race;
import service.RaceService;

@Data
public class RaceServiceImpl implements RaceService {

    HorseServiceImpl horseService;
    Race race;

    public Race getRace() {
        race.setHorsesInRace(horseService.getRandomHorses(race.getNumberOfHorses()));
        return race;
    }
}
