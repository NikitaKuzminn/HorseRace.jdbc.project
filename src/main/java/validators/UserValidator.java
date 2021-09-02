package validators;

import entity.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.regex.Pattern;

public class UserValidator {

    public void validate(User user) {
        Pattern validName = Pattern.compile("^[a-zA-Z]+$");
        if (user.getFirst_name().isBlank()) {
            throw new UnsupportedOperationException("Empty first name");
        } else if (!(user.getFirst_name().length() == 1 || user.getFirst_name().length() > 15
                && validName.matcher(user.getFirst_name()).find())) {
            throw new UnsupportedOperationException("Invalid first name value");
        }

        if (user.getLast_name().isBlank()) {
            throw new UnsupportedOperationException("Empty last name");
        } else if ((user.getLast_name().length() == 1 || user.getLast_name().length() > 15
                && validName.matcher(user.getLast_name()).find())) {
            throw new UnsupportedOperationException("Invalid last name value");
        }

        if (user.getDob() == null) {
            throw new UnsupportedOperationException("Empty date of birth");
        } else {
            LocalDate current = LocalDate.now();
            Date birth = user.getDob();
            String birthString = new SimpleDateFormat("dd-MM-yyyy").format(birth);
            LocalDate localDate = LocalDate.parse(birthString);
            int age = Period.between(current, localDate).getYears();
            if (age < 18 || age > 100) {
                throw new UnsupportedOperationException("Invalid date of birth");
            }
        }
    }
}

