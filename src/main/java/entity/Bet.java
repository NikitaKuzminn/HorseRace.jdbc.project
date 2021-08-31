package entity;

import java.util.Objects;

public class Bet {
    private int id;
    private int user_id;
    private int horse;
    private int rate_value;

    public Bet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user_id;
    }

    public void setUser(int user) {
        this.user_id = user;
    }

    public int getHorse() {
        return horse;
    }

    public void setHorse(int horse) {
        this.horse = horse;
    }

    public int getRate_value() {
        return rate_value;
    }

    public void setRate_value(int rate_value) {
        this.rate_value = rate_value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return id == bet.id && user_id == bet.user_id && horse == bet.horse && rate_value == bet.rate_value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, horse, rate_value);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", user=" + user_id +
                ", horse=" + horse +
                ", rate_value=" + rate_value +
                '}';
    }
}
