package main.java.by.bsuir.WT.lab2.entity;

public class Speakers extends Appliance{
    private int powerConsumption;
    private int numberOfSpeakers;
    private double frequencyRangeMin;
    private double frequencyRangeMax;
    private int cordLength;

    public Speakers() {}

    public Speakers(double price, String name, int powerConsumption, int numberOfSpeakers, double frequencyRangeMin, double frequencyRangeMax, int cordLength) {
        super(price, name);
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRangeMin = frequencyRangeMin;
        this.frequencyRangeMax = frequencyRangeMax;
        this.cordLength = cordLength;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getFrequencyRangeMin() {
        return frequencyRangeMin;
    }

    public void setFrequencyRangeMin(double frequencyRangeMin) {
        this.frequencyRangeMin = frequencyRangeMin;
    }

    public double getFrequencyRangeMax() {
        return frequencyRangeMax;
    }

    public void setFrequencyRangeMax(double frequencyRangeMax) {
        this.frequencyRangeMax = frequencyRangeMax;
    }

    public int getCordLength() {
        return cordLength;
    }

    public void setCordLength(int cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", numberOfSpeakers=" + numberOfSpeakers +
                ", frequencyRangeMin=" + frequencyRangeMin +
                ", frequencyRangeMax=" + frequencyRangeMax +
                ", cordLength=" + cordLength +
                '}';
    }
}
