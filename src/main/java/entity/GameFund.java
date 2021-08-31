package entity;

import java.math.BigInteger;
import java.util.Objects;


public class GameFund {

    private int id;
    private int user_id;
    private int plus_minus;

    private long found;


    public GameFund() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPlus_minus() {
        return plus_minus;
    }

    public void setPlus_minus(int plus_minus) {
        this.plus_minus = plus_minus;
    }

    public long getFound() {
        return found;
    }

    public void setFound(long found) {
        this.found = found;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameFund gameFund = (GameFund) o;
        return id == gameFund.id && user_id == gameFund.user_id && plus_minus == gameFund.plus_minus && found == gameFund.found;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, plus_minus, found);
    }

    @Override
    public String toString() {
        return "GameFund{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", plus_minus=" + plus_minus +
                ", found=" + found +
                '}';
    }
}
