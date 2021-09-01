package entity;

import java.sql.Date;
import java.util.Objects;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private Date dob;
    private int user_cash;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getUser_cash() {
        return this.user_cash;
    }

    public void setUser_cash(int user_cash) {
        this.user_cash = user_cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && user_cash == user.user_cash && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(dob, user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, dob, user_cash);
    }

    @Override
    public String toString() {
        return "id=" + id +
                " " + first_name +
                " " + last_name +
                ", " + dob +
                ", $" + user_cash +
                "\n";
    }
}
