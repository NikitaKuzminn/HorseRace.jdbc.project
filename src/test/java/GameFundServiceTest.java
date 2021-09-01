
import dao.GameFundDao;
import dao.GameFundDaoImpl;
import entity.GameFund;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.GameFundService;
import service.GameFundServiceImpl;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class GameFundServiceTest {

    @InjectMocks
    private GameFundService gameFundService = new GameFundServiceImpl();
    @Mock
    private GameFundDao gameFundDao = new GameFundDaoImpl();
    private GameFund gameFund = null;


    @BeforeEach
    public void setUp() {
        gameFund = new GameFund();

        gameFund.setUser_id(2);
        gameFund.setPlus_minus(1000);


    }

    @Test
    public void findBetTest() throws SQLException {
        given(gameFundDao.getById(gameFund.getId())).willReturn(gameFund);
        GameFund expected = gameFundService.getById(gameFund.getId());
        assertNotNull(expected);
    }

    @Test
    public void getAllTest() throws SQLException {
        List<GameFund> list = gameFundDao.getAll();
        given(gameFundDao.getAll()).willReturn(list);
        List<GameFund> expected = gameFundService.getAll();
        assertEquals(expected, list);
    }

    @Test
    public void deleteDaoTest() throws SQLException {
        gameFundService.add(gameFund);
        gameFundService.remove(gameFund);
        assertNull(gameFundService.getById(gameFund.getId()));
    }

    @Test
    public void sumTest() throws SQLException {
        assertEquals(gameFundService.getSum(), gameFundDao.getSum());
    }
}
