package bl;

import entity.*;
import service.*;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Bookmaker {
    Hippodrome game = new Hippodrome();
    GameFundService gameFundService = new GameFundServiceImpl();
    UserService userService = new UserServiceImpl();
    BetService betService = new BetServiceImpl();
    HorseService horseService = new HorseServiceImpl();
    HorseRaceService horseRaceService = new HorseRaceServiceImpl();


    final int min = 10;
    List<User> users;
    List<Horse> horses;
    List<Bet> bets = betService.getAll();

    public Bookmaker() throws SQLException {
    }

    public void acceptBets() throws SQLException {
        if (betService.getAll().isEmpty()) {
            users = userService.getAll();
            Collections.shuffle(users);
            horses = horseService.getAll();
            Collections.shuffle(horses);

            for (int i = 0; i < users.toArray().length; i++) {
                Bet bet = new Bet();

                bet.setUser(users.get(i).getId());
                try {
                    bet.setHorse(horses.get(i).getId());
                } catch (Exception e) {
                    bet.setHorse(horses.get(i - 4).getId());
                }

                GameFund gameFund = new GameFund();
                int cash = users.get(i).getUser_cash();
                if (cash == 0) {
                    userService.removeById(users.get(i).getId());
                    System.out.println("Better" + users.get(i).getFirst_name()
                            + users.get(i).getLast_name() + " was expelled due to bankruptcy");
                    return;
                }
                int max = 2000;
                int rateValue = new Random().ints(min, max).iterator().nextInt();
                int freshCash = cash - rateValue;

                gameFund.setPlus_minus(rateValue);
                gameFund.setUser_id(users.get(i).getId());
                gameFundService.add(gameFund);


                bet.setRate_value(rateValue);
                userService.updateCash(users.get(i).getId(), freshCash);

                betService.add(bet);
            }
        }else {
            System.out.println("Bets have already been placed");
        }
    }


    public void winner() throws SQLException {
        if (!bets.isEmpty()) {

            for (Bet bet : bets) {

                int userId = bet.getUser();
                int horseId = bet.getHorse();

                Horse horse = horseService.getById(horseId);

                if (horse.equals(game.getWinner())) {
                    GameFund gameFund = new GameFund();
                    User user = userService.getById(userId);
                    gameFund.setUser_id(userId);

                    int moneyWon = (int) (bet.getRate_value() * horse.getCoefficient());
                    int freshCash = moneyWon + user.getUser_cash() + bet.getRate_value();
                    gameFund.setPlus_minus(-moneyWon);

                    userService.updateCash(userId, freshCash);
                    gameFundService.add(gameFund);

                    System.out.println(user.getFirst_name() + " " + user.getLast_name() + " won: $" + moneyWon);

                }
            }

            HorseRace horseRace = new HorseRace();
            horseRace.setWinner(game.getWinner().getHorse_name());
            horseRaceService.add(horseRace);

            for (Bet bet : bets) {
                betService.remove(bet);
            }
        }
    }
}

