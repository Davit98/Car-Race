package com.company;


import com.company.cars.Car;
import com.company.roads.Road;

import java.io.IOException;
import java.util.*;


public class Game {
    private Road road;
    private ArrayList<Car> racingCars;

    public Game(int roadLength) throws IOException {
        road = new Road(roadLength);
        road.buildRoad();
        racingCars = Garage.getRacingCars();
        System.out.println("Cars on road");
        for (Car racingCar : racingCars) System.out.println(racingCar);
        System.out.println();
    }

    private void currentLeaderBoard(Map<Car, Integer> carToPosition) {
        ArrayList<Car> list = new ArrayList<>(carToPosition.keySet());
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return carToPosition.get(o2).compareTo(carToPosition.get(o1));
            }
        });
        for(Car car: list) {
            System.out.println(car.getType() + " " + car.getName() + " " + car.getEngine() + " passed: " + carToPosition.get(car));
        }
        System.out.println();
    }

    public void race() {
        Map<Car,Integer> carToRoadIndex = new HashMap<>();
        ArrayList<Car> finishedCars = new ArrayList<>();
        for(Car car: racingCars)
            carToRoadIndex.put(car, 0);
        while(!carToRoadIndex.isEmpty()) {
            for(Car car: carToRoadIndex.keySet()) {
                int x = car.move(road.getRoadBlocks().get(carToRoadIndex.get(car)));
                carToRoadIndex.put(car,carToRoadIndex.get(car)+x);
                if(carToRoadIndex.get(car)>=road.getRoadLength()) {
                    System.out.println(car.getType() + " " + " " + car.getName() + " finished");
                    finishedCars.add(car);
                }
            }
            for(Car car: finishedCars) {
                carToRoadIndex.remove(car);
            }
            currentLeaderBoard(carToRoadIndex);
            finishedCars.clear();
        }
    }
}
