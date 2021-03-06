package bl;

import entity.Bet;
import entity.Horse;
import entity.User;
import service.*;
import validators.HorseValidator;
import validators.UserValidator;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Console {

    Hippodrome game = new Hippodrome();
    BetService betService = new BetServiceImpl();
    Bookmaker bookmaker = new Bookmaker();
    HorseService horseService = new HorseServiceImpl();
    UserService userService = new UserServiceImpl();
    GameFundService gameFundService = new GameFundServiceImpl();
    HorseRaceService horseRaceService = new HorseRaceServiceImpl();
    HorseValidator horseValidator = new HorseValidator();
    UserValidator userValidator = new UserValidator();
    List<User> users = null;
    List<Horse> horses = null;
    Scanner scanner = new Scanner(System.in);

    public Console() throws SQLException {
    }

    public static void run() throws SQLException, ParseException, InterruptedException {
        Console console = new Console();
        console = console.mainMenu(console);
        System.out.println("Application has been shut down");
    }

    private Console mainMenu(Console console) throws SQLException, ParseException, InterruptedException {
        System.out.println("Welcome, have a nice work day");

        int selection = 0;


        do {
            System.out.println("[1] Batters");
            System.out.println("[2] Horses");
            System.out.println("[3] Bets");
            System.out.println("[4] Race");
            System.out.println("[5] Game fund");
            System.out.println("[6] Quit");

            System.out.print("Insert selection: ");
            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    return console.bettersSubmenu(console);
                case 2:
                    return console.horsesSubmenu(console);
                case 3:
                    return console.betsSubmenu(console);
                case 4:
                    return console.raceSubmenu(console);
                case 5:
                    return console.gameFundSubmenu(console);
                case 6:
                    return console;
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 4);
        return console;
    }

    private Console bettersSubmenu(Console console) throws SQLException, ParseException, InterruptedException {
        System.out.println("Betters submenu");
        System.out.println("");

        int selection = 0;

        do {
            System.out.println("[1] Get a list of betters");
            System.out.println("[2] Register a new better");
            System.out.println("[3] Exclude better");
            System.out.println("[4] Return");

            System.out.print("Insert selection: ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println(userService.getAll());
                    return console.bettersSubmenu(console);
                case 2:
                    User user = new User();

                    System.out.print("Enter a first name: ");
                    user.setFirst_name(scanner.next());

                    System.out.print("Enter a last name: ");
                    user.setLast_name(scanner.next());
                    System.out.println("Enter the better's date of birth:");
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Month: ");
                    int month = scanner.nextInt();
                    System.out.print("Day: ");
                    int day = scanner.nextInt();
                    String dateString = year + "-" + month + "-" + day;
                    Date date = Date.valueOf(dateString);
                    user.setDob(date);
                    System.out.print("Enter the amount of the initial contribution: ");
                    user.setUser_cash(scanner.nextInt());
                    try {
                        userValidator.validate(user);
                    } catch (UnsupportedOperationException e) {
                        System.err.println(e.getMessage());
                        return console.bettersSubmenu(console);
                    }
                    userService.add(user);

                    System.out.println("You have successfully added a better");
                    return console.bettersSubmenu(console);

                case 3:
                    System.out.println("Enter the id of the better you want to exclude: ");
                    userService.removeById(scanner.nextInt());
                    return console.bettersSubmenu(console);

                case 4:
                    return console.mainMenu(console);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 4);
        return console;
    }

    private Console horsesSubmenu(Console console) throws SQLException, ParseException, InterruptedException {
        System.out.println("Horses sub menu");

        int selection = 0;

        do {
            System.out.println("[1] Get a list of horses");
            System.out.println("[2] Register a new horse");
            System.out.println("[3] Delete a horse");
            System.out.println("[4] Return");

            System.out.print("Insert selection: ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println(horseService.getAll());
                    return console.horsesSubmenu(console);
                case 2:
                    Horse horse = new Horse();
                    System.out.print("Enter a horse name: ");
                    horse.setHorse_name(scanner.next());
                    System.out.print("Enter the coefficient (1,5 is recommended for new horses): ");
                    horse.setCoefficient(scanner.nextDouble());
                    try{
                        horseValidator.validate(horse);
                    }catch (UnsupportedOperationException e){
                        System.err.println(e.getMessage());
                        return console.horsesSubmenu(console);
                    }
                    horseService.add(horse);
                    System.out.println("You have successfully added a horse");
                    return console.horsesSubmenu(console);

                case 3:
                    System.out.println("Enter the id of the better you want to delete: ");
                    horseService.removeById(scanner.nextInt());

                case 4:
                    return console.mainMenu(console);

                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 4);
        return console;
    }

    private Console betsSubmenu(Console console) throws SQLException, ParseException, InterruptedException {
        System.out.println("Bets submenu");
        System.out.println("");

        int selection = 0;

        do {
            System.out.println("[1] Accept rates");
            System.out.println("[2] Get a list of bets");
            System.out.println("[3] Add a bet manually");
            System.out.println("[4] Delete a bet");
            System.out.println("[5] Return");

            System.out.print("Insert selection: ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    bookmaker.acceptBets();
                    System.out.println("Bets on the next run have been made");
                    return console.betsSubmenu(console);
                case 2:
                    System.out.println(betService.getAll());
                    return console.betsSubmenu(console);
                case 3:
                    Bet bet = new Bet();
                    System.out.println("Enter the id of the better :");
                    int userId = scanner.nextInt();
                    int realUserId = 0;
                    users = userService.getAll();
                    for (User user : users) {
                        if (userId == user.getId()) {
                            realUserId = user.getId();
                            break;
                        }
                    }
                    if (realUserId == 0) {
                        System.err.println("Invalid better id");
                        return console.betsSubmenu(console);
                    }

                    bet.setUser(realUserId);

                    System.out.println("Enter the id of the horse: ");
                    int horseId = scanner.nextInt();
                    int realHorseId = 0;
                    horses = horseService.getAll();
                    for (Horse horse : horses) {
                        if (horseId == horse.getId()) {
                            realHorseId = horse.getId();
                            break;
                        }
                    }
                    if (realHorseId == 0) {
                        System.err.println("Invalid horse number");
                        return console.betsSubmenu(console);
                    }
                    bet.setHorse(realHorseId);

                    System.out.println("Enter the amount of money to bet: ");
                    bet.setRate_value(scanner.nextInt());

                    betService.add(bet);

                    System.out.println("You have successfully added a bet");

                    return console.betsSubmenu(console);
                case 4:
                    System.out.println("Enter the id of the bet you want to delete: ");
                    betService.removeById(scanner.nextInt());

                    return console.betsSubmenu(console);

                case 5:
                    return console.mainMenu(console);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 5);
        return console;
    }

    private Console raceSubmenu(Console console) throws SQLException, ParseException, InterruptedException {
        System.out.println("Welcome to the SUBMENU");

        int selection = 0;

        do {
            System.out.println("[1] Start a race");
            System.out.println("[2] Winners of past races");
            System.out.println("[3] Return");

            System.out.print("Insert selection: ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    List<Bet> bets = betService.getAll();
                    if (!bets.isEmpty()) {
                        game.run();
                        game.printWinner();
                        bookmaker.winner();
                    } else {
                        System.out.println("No bets have been placed");
                    }

                    return console.raceSubmenu(console);
                case 2:
                    System.out.println(horseRaceService.getAll());
                    return console.raceSubmenu(console);

                case 3:
                    return console.mainMenu(console);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 3);
        return console;
    }

    private Console gameFundSubmenu(Console console) throws SQLException, ParseException, InterruptedException {
        System.out.println("Game fund submenu");

        int selection = 0;

        do {
            System.out.println("[1] Game fund");
            System.out.println("[2] Profit and loss");
            System.out.println("[3] Return");

            System.out.print("Insert selection: ");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Game fund: " + gameFundService.getSum());
                    return console.gameFundSubmenu(console);
                case 2:
                    System.out.println(gameFundService.getAll());
                    return console.gameFundSubmenu(console);
                case 3:
                    return console.mainMenu(console);
                default:
                    System.out.println("The selection was invalid!");
            }
        } while (selection != 3);
        return console;
    }
}




