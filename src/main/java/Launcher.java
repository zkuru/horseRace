import model.Race;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.RaceService;
import service.impl.RaceServiceImpl;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        RaceService raceService = (RaceServiceImpl) context.getBean("raceService");
        Race race = raceService.getRace();
        System.out.println(race.getDistance());
        System.out.println(race.getNumberOfHorses());
        System.out.println(race.getHorsesInRace());

    }
}
