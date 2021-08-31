package bl;
import entity.Horse;
import entity.HorseRace;
import service.HorseRaceService;
import service.HorseRaceServiceImpl;
import service.HorseService;
import service.HorseServiceImpl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private static HorseService horseService = new HorseServiceImpl();
    private static List<Horse> horses;
    private static HorseRaceService horseRaceService = new HorseRaceServiceImpl();

    static {
        try {
            horses = horseService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome() {

    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;

    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            move();
            print();
            Thread.sleep(1000);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparingDouble(Horse::getDistance))
                .get();
    }

    public void printWinner() throws SQLException {
       System.out.println("Winner is "+getWinner().getHorse_name()+"!");



    }


    public static void main(String[] args) throws InterruptedException, SQLException {
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
