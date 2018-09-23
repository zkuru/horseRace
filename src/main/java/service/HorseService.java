package service;

import model.Horse;

import java.util.Collection;

public interface HorseService {
   Horse getHorseByName(String name);

   Horse getHorseByRider(String riderName);

   Horse getHorseByBreed(String breed);

   Collection<Horse> getRandomHorses(int numberOfHorses);
}
