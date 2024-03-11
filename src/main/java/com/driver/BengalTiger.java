package com.driver;

public class BengalTiger implements Tiger {
    @Override
    public String getType() {
        return "Bengal Tiger";
    }

    @Override
    public String getColor() {
        return "Orange with black stripes";
    }

    @Override
    public double getAverageWeight() {
        return 220.0;
    }

    @Override
    public String getPreferredClimate() {
        return "Subtropical";
    }
}

