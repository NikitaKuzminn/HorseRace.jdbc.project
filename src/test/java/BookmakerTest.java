import bl.Bookmaker;
import entity.Bet;
import org.junit.jupiter.api.Test;
import service.BetService;
import service.BetServiceImpl;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookmakerTest {
Bookmaker bookmaker = new Bookmaker();
BetService betService = new BetServiceImpl();

    public BookmakerTest() throws SQLException {
    }

    @Test
    public void acceptBetsTest() throws SQLException {

        List<Bet> list = betService.getAll();
        if (list.isEmpty()){
        bookmaker.acceptBets();
        list = betService.getAll();
            assertFalse(list.isEmpty());
        } else {
            for (Bet bet : list){
                betService.remove(bet);
            }
            bookmaker.acceptBets();
            assertFalse(list.isEmpty());
        }
    }
}
