package com.driver;

public class SumatranTiger implements Tiger {
    @Override
    public String getType() {
        return "Sumatran Tiger";
    }

    @Override
    public String getColor() {
        return "Orange with thinner black stripes";
    }

    @Override
    public double getAverageWeight() {
        return 140.0;
    }

    @Override
    public String getPreferredClimate() {
        return "Tropical";
    }
}

