package com.driver;

public class SiberianTiger implements Tiger {
    @Override
    public String getType() {
        return "Siberian Tiger";
    }

    @Override
    public String getColor() {
        return "White with black stripes";
    }

    @Override
    public double getAverageWeight() {
        return 300.0;
    }

    @Override
    public String getPreferredClimate() {
        return "Cold";
    }
}
