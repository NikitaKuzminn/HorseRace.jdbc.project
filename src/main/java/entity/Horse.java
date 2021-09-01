package entity;

import java.util.Objects;

public class Horse {
    private int id;
    private String horse_name;
    private double coefficient;
    private double distance = 3;
    private double speed = 3;

    public Horse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorse_name() {
        return horse_name;
    }

    public void setHorse_name(String horse_name) {
        this.horse_name = horse_name;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return id == horse.id && Double.compare(horse.coefficient, coefficient) == 0 && Objects.equals(horse_name, horse.horse_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horse_name, coefficient);
    }

    @Override
    public String toString() {
        return "Horse: " +
                "number: " + id +
                ", horse name='" + horse_name + '\'' +
                ", coefficient=" + coefficient +
                '\n';
    }

    public double getDistance() {
        return this.distance;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void print() {
        StringBuilder sg = new StringBuilder("");
        for (int i = 0; i < (int) getDistance(); i++) {
            sg.append(".");
        }
        System.out.println(sg + this.horse_name);
    }

    public void move() {
        distance += speed * Math.random();
    }

}
