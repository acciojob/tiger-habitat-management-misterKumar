package com.driver;

public class SiberianTiger implements Tiger {
    private String color;
    private double averageWeight;
    private String preferredClimate;

    @Override
    public String getType() {
        return "Siberian Tiger";
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getAverageWeight() {
        return averageWeight;
    }

    @Override
    public String getPreferredClimate() {
        return preferredClimate;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setAverageWeight(double averageWeight) {
        this.averageWeight = averageWeight;
    }

    @Override
    public void setPreferredClimate(String preferredClimate) {
        this.preferredClimate = preferredClimate;
    }
}
