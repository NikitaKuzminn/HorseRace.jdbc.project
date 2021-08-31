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
    List<Bet> bets;

    public void acceptBets() throws SQLException {

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
            int rateValue = new Random().ints(min, cash + 1).iterator().nextInt();
            int freshCash = cash - rateValue;

            gameFund.setPlus_minus(rateValue);
            gameFund.setUser_id(users.get(i).getId());
            gameFundService.add(gameFund);


            bet.setRate_value(rateValue);
            userService.updateCash(users.get(i).getId(), freshCash);

            betService.add(bet);

        }
    }


    public void winner() throws SQLException {

        bets = betService.getAll();

        if (bets.isEmpty()) {
            System.out.println("No bets have been placed ");
        } else {
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

                    System.out.println(user.getFirst_name() + " " + user.getLast_name() + " won: " + moneyWon);

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
