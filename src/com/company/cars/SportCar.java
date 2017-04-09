package com.company.cars;

import com.company.roads.RoadBlock;

public class SportCar extends Car{
    public SportCar(String name, int weight, Engine engine) {
        super("S",name,weight,engine);
    }
    @Override
    public int move(RoadBlock roadBlock) {
        this.setInitialSpeed();
        if(roadBlock.getResistance()!=1)
            speed /= (roadBlock.getResistance() * 2);
        return speed;
    }
}
