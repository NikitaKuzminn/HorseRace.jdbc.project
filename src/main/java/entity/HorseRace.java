package entity;

import java.util.Objects;

public class HorseRace {
    private int id;
    private String winner;

    public HorseRace() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorseRace horseRace = (HorseRace) o;
        return id == horseRace.id && Objects.equals(winner, horseRace.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, winner);
    }

    @Override
    public String toString() {
        return "Race: " + id +
                ", Winner ='" + winner + '\'' +
                '\n';
    }
}
