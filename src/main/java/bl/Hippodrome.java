package bl;

import entity.Horse;
import service.*;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private static final HorseService horseService = new HorseServiceImpl();
    private static List<Horse> horses;

    static {
        try {
            horses = horseService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Hippodrome() {

    }

    public void run() throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            move();
            print();
            Thread.sleep(500);
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

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getHorse_name() + "!");

    }
}
