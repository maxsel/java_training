package by.epam.taxistation.entity;

import by.epam.taxistation.exception.IllegalSetValueException;
import by.epam.taxistation.utility.IdGenerator;

public class Taxi extends Car {
    private int taxiId;
    private int priceKm;

    public int getTaxiId() {
        return taxiId;
    }

    public int getPriceKm() {
        return priceKm;
    }

    public void setPriceKm(int priceKm) {
        this.priceKm = priceKm;
    }

    public Taxi(String registrationIdentifier) throws IllegalSetValueException {
        super(registrationIdentifier);
        this.taxiId = IdGenerator.generate();
    }

    public Taxi(String registrationIdentifier, String make, String model,
                int year, int cost, String driver, int fuelConsumption,
                int seatsNumber, int maxWeight, int priceKm)
            throws IllegalSetValueException {
        super(registrationIdentifier, make, model,
                year, cost, driver, fuelConsumption,
                seatsNumber, maxWeight, DrivingLicenceType.B);
        this.taxiId = IdGenerator.generate();
        this.priceKm = priceKm;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Taxi{");
        sb.append("ID=").append(getTaxiId());
        sb.append(", ").append(super.toString());
        sb.append(", priceKm=").append(getPriceKm());
        sb.append('}');
        return sb.toString();
    }
}
