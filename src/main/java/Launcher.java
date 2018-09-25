import model.Horse;
import model.Race;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.EmulationService;
import service.HorseService;
import service.RaceService;
import service.impl.EmulationServiceImpl;
import service.impl.HorseServiceImpl;
import service.impl.RaceServiceImpl;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        getRaceInformation(context);
        chooseHorse(context);
        startRace(context);
    }
    private static void getRaceInformation(ApplicationContext context) {
        System.out.println();
        RaceService raceService = (RaceServiceImpl) context.getBean("raceService");
        Race race = raceService.getRace();
        System.out.println(race.getDistance());
        System.out.println(race.getNumberOfHorses());
        race.getHorsesInRace().stream().forEach(System.out::println);
    }

    private static void chooseHorse(ApplicationContext context) {
        System.out.println();
        System.out.println("Choose the horse");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HorseService horseService = (HorseServiceImpl) context.getBean("horseService");
        Horse horseByName = horseService.getHorseByName(s);
        System.out.println("Your choice: " + horseByName.getName());
    }

    private static void startRace(ApplicationContext context) throws InterruptedException {
        EmulationService emulationService = (EmulationServiceImpl) context.getBean("emulationService");
        emulationService.getCurrentStateOfRace();
    }
}
