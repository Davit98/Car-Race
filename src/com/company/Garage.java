package com.company;

import com.company.cars.Car;
import com.company.cars.Engine;
import com.company.cars.JeepCar;
import com.company.cars.SportCar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Garage {

    private static ArrayList<Engine> takeEngines() throws IOException {
        ArrayList<Engine> engines = new ArrayList<>();
        File file = new File("engines.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String engineMetadata;
        while ((engineMetadata = reader.readLine()) != null) {
            engines.add(createEngine(engineMetadata));
        }
        return engines;
    }
    private static Engine createEngine(String metadata) {
        String[] engineMd = metadata.split(",");
        String name = engineMd[0].trim();
        int power = Integer.parseInt(engineMd[1].trim());
        return new Engine(name, power);
    }

    private static ArrayList<Car> takeCars() throws IOException {
        ArrayList<Car> cars = new ArrayList<>();
        File file = new File("cars.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String carMetadata;
        while ((carMetadata = reader.readLine()) != null) {
            cars.add(createCar(carMetadata));
        }
        return cars;
    }

    private static Car createCar(String metadata) {
        String[] carMd = metadata.split(",");
        String type = carMd[0].trim();
        String name = carMd[1].trim();
        int weight = Integer.parseInt(carMd[2].trim());
        if (type.equals("J"))
            return new JeepCar(name, weight, null);
        else if (type.equals(("S")))
            return new SportCar(name, weight, null);
        else
            return null;
    }

    public static ArrayList<Car> getRacingCars() throws IOException {
        ArrayList<Car> racingCars = new ArrayList<>();
        ArrayList<Car> cars = takeCars();
        ArrayList<Engine> engines = takeEngines();
        int r = 0;
        Collections.shuffle(cars);
        for(Engine engine: engines) {
            cars.get(r).setEngine(engine);
            racingCars.add(cars.get(r));
            r++;
        }
        return racingCars;
    }
}
