package validators;

import entity.Horse;
import service.HorseService;
import service.HorseServiceImpl;

import java.util.regex.Pattern;

public class HorseValidator {

    public void validate(Horse horse) {
        HorseService horseService = new HorseServiceImpl();

        Pattern validName = Pattern.compile("^[a-zA-Z]+$");
        if (horse.getHorse_name().isBlank()) {
            throw new UnsupportedOperationException("Empty name");
        }
        else if (!(horse.getHorse_name().length() == 1 || horse.getHorse_name().length() > 12
                && validName.matcher(horse.getHorse_name()).find())){
            throw new UnsupportedOperationException("Invalid name");
        }

        if(horse.getCoefficient() < 1 || horse.getCoefficient() > 10 ){
            throw new UnsupportedOperationException("The coefficient cannot be more than ten");
        }

    }
}
