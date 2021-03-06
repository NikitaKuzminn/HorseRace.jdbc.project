import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entity.User;
import validators.UserValidator;

import java.sql.Date;

import static org.testng.Assert.assertThrows;



public class UserValidatorTest {
    User user = null;
    UserValidator userValidator = new UserValidator();


    @BeforeEach
    public void setUp(){
        user = new User();
        user.setFirst_name("Nikita");
        user.setLast_name("Kuzmin");
        user.setUser_cash(5000);
    }

    @Test
    public void firstNameValidateTest(){
        user.setFirst_name("1");
        assertThrows(UnsupportedOperationException.class, () -> userValidator.validate(user)
        );
    }

    @Test
    public void lastNameValidateTest(){
        user.setFirst_name("");
        assertThrows(UnsupportedOperationException.class, () -> userValidator.validate(user)
        );
    }

    @Test
    public void dateOfBirthValidateTest(){
        String s = "2009-12-01";
        Date date = Date.valueOf(s);
        user.setDob(date);
        assertThrows(UnsupportedOperationException.class, () -> userValidator.validate(user)
        );
    }
}
