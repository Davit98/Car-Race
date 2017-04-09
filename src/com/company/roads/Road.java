package com.company.roads;


import java.util.ArrayList;
import java.util.Random;


public class Road {
    private int roadLength;
    private ArrayList<RoadBlock> roadBlocks = new ArrayList<>();


    public Road(int roadLength) {
        this.roadLength = roadLength;
    }


    Random random = new Random();
    public void buildRoad() {
        for(int i=0;i<roadLength;i++) {
            int r = random.nextInt(4);
            switch (r) {
                case 0:
                    roadBlocks.add(new GoodBlock());
                    break;
                case 1:
                    roadBlocks.add(new NormalBlock());
                    break;
                case 2:
                    roadBlocks.add(new BadBlock());
                    break;
                case 3:
                    roadBlocks.add(new VeryBadBlock());
                    break;
            }
        }
    }

    public int getRoadLength() {
        return roadLength;
    }
    public ArrayList<RoadBlock> getRoadBlocks() {
        return roadBlocks;
    }

}
