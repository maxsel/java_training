package by.epam.selyuk.taxistation.entity;

import by.epam.selyuk.taxistation.exception.IllegalSetValueException;
import by.epam.selyuk.taxistation.utility.IdGenerator;

public class TaxiLorry extends Car {
    public final int TAXILORRY_ID = IdGenerator.generate();
    private int maxHeight;
    private int priceHour;

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) {
        this.priceHour = priceHour;
    }

    public TaxiLorry(String registrationIdentifier) throws IllegalSetValueException {
        super(registrationIdentifier);
    }

    public TaxiLorry(String registrationIdentifier, String make, String model, int year, int cost,
                     String driver, int fuelConsumption, int seatsNumber, int maxWeight,
                     int maxHeight, int priceHour) throws IllegalSetValueException {
        super(registrationIdentifier, make, model, year, cost,
                driver, fuelConsumption, seatsNumber, maxWeight, DrivingLicenceType.C);
        this.maxHeight = maxHeight;
        this.priceHour = priceHour;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TaxiLorry{");
        sb.append("ID=").append(TAXILORRY_ID);
        sb.append(", ").append(super.toString());
        sb.append(", maxHeight=").append(getMaxHeight());
        sb.append(", priceHour=").append(getPriceHour());
        sb.append('}');
        return sb.toString();
    }
}
