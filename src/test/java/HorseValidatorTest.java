import entity.Horse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import validators.HorseValidator;
import static org.testng.Assert.assertThrows;

public class HorseValidatorTest {
    HorseValidator horseValidator = new HorseValidator();
    Horse horse = null;
    Horse horseSecond = null;

    @BeforeEach
    public void setUp(){
       horse = new Horse();
       horse.setHorse_name("");
       horse.setCoefficient(2.3);

       horseSecond = new Horse();
       horseSecond.setHorse_name("Name");
       horseSecond.setCoefficient(13);
    }

    @Test
    public void nameValidateTest() {
        assertThrows(UnsupportedOperationException.class, () -> horseValidator.validate(horse)
        );
    }

    @Test
    public void coefficientValidateTest(){
        assertThrows(UnsupportedOperationException.class, () -> horseValidator.validate(horseSecond)
        );
    }

    @Test
    public void coefficientValidateSecondTest(){
        horseSecond.setCoefficient(0);
        assertThrows(UnsupportedOperationException.class, () -> horseValidator.validate(horseSecond)
        );
    }



}
