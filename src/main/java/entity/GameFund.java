package entity;

import java.math.BigInteger;


public class GameFund {

    private int id;
    private int user_id;
    private int plus_minus;

    private long found;



    public GameFund(){
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
}
