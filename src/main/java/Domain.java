import service.GameFundService;
import service.GameFundServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Domain {

    public static void main(String[] args) throws SQLException, InterruptedException, ParseException {
/*        Bookmaker bookmaker = new Bookmaker();
        GameFund gameFund = new GameFund();
        System.out.println(gameFund.getFound());

        bookmaker.acceptBets();
        Hippodrome game = new Hippodrome();
        System.out.println(gameFund.getFound());
        game.run();
        game.printWinner();
        bookmaker.winner();

        System.out.println(gameFund.getFound());*/


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = "1992-01-02";
        Date formatDate = format.parse(date);
        System.out.println(formatDate);





    }
}
