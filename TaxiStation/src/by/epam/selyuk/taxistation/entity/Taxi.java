package by.epam.selyuk.taxistation.entity;

import by.epam.selyuk.taxistation.exception.IllegalSetValueException;
import by.epam.selyuk.taxistation.utility.IdGenerator;

public class Taxi extends Car {
    public final int TAXI_ID = IdGenerator.generate();
    private int priceKm;

    public int getPriceKm() {
        return priceKm;
    }

    public void setPriceKm(int priceKm) {
        this.priceKm = priceKm;
    }

    public Taxi(String registrationIdentifier) throws IllegalSetValueException {
        super(registrationIdentifier);
    }

    public Taxi(String registrationIdentifier, String make, String model, int year, int cost,
                String driver, int fuelConsumption, int seatsNumber, int maxWeight, int priceKm)
            throws IllegalSetValueException {
        super(registrationIdentifier, make, model, year, cost,
                driver, fuelConsumption, seatsNumber, maxWeight, DrivingLicenceType.B);
        this.priceKm = priceKm;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Taxi{");
        sb.append("ID=").append(TAXI_ID);
        sb.append(", ").append(super.toString());
        sb.append(", priceKm=").append(getPriceKm());
        sb.append('}');
        return sb.toString();
    }
}
