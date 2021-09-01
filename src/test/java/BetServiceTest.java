import dao.BetDaoImpl;
import entity.Bet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.BetServiceImpl;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class BetServiceTest {

    @InjectMocks
    private BetServiceImpl betService = new BetServiceImpl();
    @Mock
    private BetDaoImpl betDao = new BetDaoImpl();
    private Bet bet = null;


    @BeforeEach
    public void setUp() throws SQLException {
        bet = new Bet();
        bet.setUser(1);
        bet.setRate_value(1000);
        bet.setHorse(4);

    }

    @Test
    public void findBetTest() throws SQLException {
        given(betDao.getById(bet.getId())).willReturn(bet);
        Bet expected = betService.getById(bet.getId());
        assertNotNull(expected);
    }

    @Test
    public void getAllTest() throws SQLException {
        List<Bet> list = betDao.getAll();
        given(betDao.getAll()).willReturn(list);
        List<Bet> expected = betService.getAll();
        assertEquals(expected, list);
    }

    @Test
    public void deleteDaoTest() throws SQLException {
        betService.add(bet);
        betService.removeById(bet.getId());
        assertNull(betService.getById(bet.getId()));
    }

}
