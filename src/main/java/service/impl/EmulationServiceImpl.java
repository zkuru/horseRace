package service.impl;

import lombok.Data;
import model.Horse;
import model.Race;
import service.EmulationService;

import java.util.List;

@Data
public class EmulationServiceImpl implements EmulationService {
    private final Race race;

    @Override
    public void getCurrentStateOfRace() throws InterruptedException {
        double distance = race.getDistance();
        List<Horse> list = (List<Horse>) race.getHorsesInRace();
        Double slowestSpeed = list.stream().map(Horse::getAverageSpeed).sorted().findFirst().orElse(null);
        while (distance > 0) {
            Thread.sleep(1000);

            System.out.println();

            list.sort((o1, o2) -> {
                double delta = o2.getAverageSpeed()* (1 + Math.random()) - o1.getAverageSpeed()* (1 + Math.random());
                if(delta > 0.00001) return 1;
                if(delta < -0.00001) return -1;
                return 0;
            });

            list.forEach(horse -> System.out.println(horse.getName()));
            distance -= slowestSpeed;
        }
        System.out.println();
        System.out.println("Winner  - " + list.get(0).getName());
    }
}
