
import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.UserService;
import service.UserServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService = new UserServiceImpl();
    @Mock
    private UserDao userDao = new UserDaoImpl();
    private User user = null;


    @BeforeEach
    public void setUp() {
        user = new User();
        user.setFirst_name("Vash");
        user.setLast_name("Uragan");
        user.setDob(new Date(1997 - 12 - 11));
        user.setUser_cash(10000);

    }

    @Test
    public void findBetTest() throws SQLException {
        given(userDao.getById(user.getId())).willReturn(user);
        User expected = userService.getById(user.getId());
        assertNotNull(expected);
    }

    @Test
    public void getAllTest() throws SQLException {
        List<User> list = userDao.getAll();
        given(userDao.getAll()).willReturn(list);
        List<User> expected = userService.getAll();
        assertEquals(expected, list);
    }

    @Test
    public void deleteDaoTest() throws SQLException {
        userService.add(user);
        userService.removeById(user.getId());
        assertNull(userService.getById(user.getId()));
    }

}