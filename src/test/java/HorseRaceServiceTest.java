
import dao.HorseRaceDao;
import dao.HorseRaceDaoImpl;

import entity.HorseRace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.HorseRaceService;
import service.HorseRaceServiceImpl;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class HorseRaceServiceTest {

    @InjectMocks
    private HorseRaceService horseRaceService = new HorseRaceServiceImpl();
    @Mock
    private HorseRaceDao horseRaceDao = new HorseRaceDaoImpl();
    private HorseRace horseRace = null;


    @BeforeEach
    public void setUp() {
        horseRace = new HorseRace();
        horseRace.setWinner("Pupok");
    }

    @Test
    public void findBetTest() throws SQLException {
        given(horseRaceDao.getById(horseRace.getId())).willReturn(horseRace);
        HorseRace expected = horseRaceService.getById(horseRace.getId());
        assertNotNull(expected);
    }

    @Test
    public void getAllTest() throws SQLException {
        List<HorseRace> list = horseRaceDao.getAll();
        given(horseRaceDao.getAll()).willReturn(list);
        List<HorseRace> expected = horseRaceService.getAll();
        assertEquals(expected, list);
    }

    @Test
    public void deleteDaoTest() throws SQLException {
        horseRaceService.add(horseRace);
        horseRaceService.remove(horseRace);
        assertNull(horseRaceService.getById(horseRace.getId()));
    }

}