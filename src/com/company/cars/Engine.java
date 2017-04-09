package com.company.cars;

public class Engine {
    private String name;
    private int power;

    public Engine(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String toString() {
        return String.format("%s %d",name, power);
    }
}
