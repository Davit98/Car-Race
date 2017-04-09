package com.company.cars;


import com.company.roads.Road;
import com.company.roads.RoadBlock;

public abstract class Car {
    private String type; // Jeep or sedan
    private String name;
    private int weight;
    protected int speed;
    private Engine engine;

    public Car(String type, String name, int weight, Engine engine) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.engine = engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setInitialSpeed() {
        speed = (engine.getPower()*100)/weight;
    }

    public String getType() {
        return type;
    }
    public abstract int move(RoadBlock roadBlock);

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }

    public String toString() {
        return String.format("%s %s %s",type, name, engine);
    }

}
