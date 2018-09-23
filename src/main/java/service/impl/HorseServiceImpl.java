package service.impl;

import exceptions.NoSuchHorseException;
import lombok.Getter;
import lombok.Setter;
import model.Horse;
import service.HorseService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
public class HorseServiceImpl implements HorseService {

    Collection<Horse> horses;

    public Collection<Horse> getRandomHorses(int numberOfHorses) {
        ArrayList<Horse> horses = new ArrayList<>(this.horses);
        Collections.shuffle(horses);
        horses.subList(numberOfHorses, horses.size()).clear();
        return horses;
    }

    @Override
    public Horse getHorseByName(String name) {
        return horses.stream()
                .filter(h-> h.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchHorseException("There is no such horse"));
    }

    @Override
    public Horse getHorseByRider(String riderName) {
        return horses.stream()
                .filter(h-> h.getRider().equals(riderName))
                .findFirst()
                .orElseThrow(() -> new NoSuchHorseException("There is no such horse"));
    }

    @Override
    public Horse getHorseByBreed(String breed) {
        return horses.stream()
                .filter(h-> h.getBreed().equals(breed))
                .findFirst()
                .orElseThrow(() -> new NoSuchHorseException("There is no such horse"));
    }

}
