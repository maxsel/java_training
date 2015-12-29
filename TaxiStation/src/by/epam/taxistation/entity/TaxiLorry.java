package by.epam.taxistation.entity;

import by.epam.taxistation.exception.IllegalSetValueException;
import by.epam.taxistation.utility.IdGenerator;

public class TaxiLorry extends Car {
    private int taxiLorryId;
    private int maxHeight;
    private int priceHour;

    public int getTaxiLorryId() {
        return taxiLorryId;
    }

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

    public TaxiLorry(String registrationIdentifier)
            throws IllegalSetValueException {
        super(registrationIdentifier);
        this.taxiLorryId = IdGenerator.generate();
    }

    public TaxiLorry(String registrationIdentifier, String make, String model,
                     int year, int cost, String driver, int fuelConsumption,
                     int seatsNumber, int maxWeight, int maxHeight, int priceHour)
            throws IllegalSetValueException {
        super(registrationIdentifier, make, model,
                year, cost, driver, fuelConsumption,
                seatsNumber, maxWeight, DrivingLicenceType.C);
        this.taxiLorryId = IdGenerator.generate();
        this.maxHeight = maxHeight;
        this.priceHour = priceHour;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TaxiLorry{");
        sb.append("ID=").append(getTaxiLorryId());
        sb.append(", ").append(super.toString());
        sb.append(", maxHeight=").append(getMaxHeight());
        sb.append(", priceHour=").append(getPriceHour());
        sb.append('}');
        return sb.toString();
    }
}
