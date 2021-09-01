import dao.HorseDao;
import dao.HorseDaoImpl;
import entity.Horse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.HorseService;
import service.HorseServiceImpl;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class HorseServiceTest {

    @InjectMocks
    private HorseService horseService = new HorseServiceImpl();
    @Mock
    private HorseDao horseDao = new HorseDaoImpl();
    Horse horse = null;


    @BeforeEach
    public void setUp() {
        horse = new Horse();
        horse.setHorse_name("TestHorse");
        horse.setCoefficient(2.44);

    }

    @Test
    public void findBetTest() throws SQLException {
        given(horseDao.getById(horse.getId())).willReturn(horse);
        Horse expected = horseService.getById(horse.getId());
        assertNotNull(expected);
    }

    @Test
    public void getAllTest() throws SQLException {
        List<Horse> list = horseDao.getAll();
        given(horseDao.getAll()).willReturn(list);
        List<Horse> expected = horseService.getAll();
        assertEquals(expected, list);
    }

    @Test
    public void deleteDaoTest() throws SQLException {
        horseService.add(horse);
        horseService.removeById(horse.getId());
        assertNull(horseService.getById(horse.getId()));
    }

}