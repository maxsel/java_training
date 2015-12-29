package by.epam.taxistation.entity;

import by.epam.taxistation.exception.IllegalSetValueException;
import by.epam.taxistation.utility.IdGenerator;

public class Minibus extends Car {
    private int minibusId;
    private int priceHour;

    public int getMinibusId() {
        return minibusId;
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) throws IllegalSetValueException {
        if (priceHour >= 0) {
            this.priceHour = priceHour;
        } else {
            throw new IllegalSetValueException("Minibus's priceHour" +
                    " cannot be less that 0.");
        }
    }

    public Minibus(String registrationIdentifier)
            throws IllegalSetValueException {
        super(registrationIdentifier);
        this.minibusId = IdGenerator.generate();
    }

    public Minibus(String registrationIdentifier, String make, String model,
                   int year, int cost, String driver, int fuelConsumption,
                   int seatsNumber, int maxWeight, int priceHour)
            throws IllegalSetValueException {
        super(registrationIdentifier, make, model,
                year, cost, driver, fuelConsumption,
                seatsNumber, maxWeight, DrivingLicenceType.D);
        setPriceHour(priceHour);
        this.minibusId = IdGenerator.generate();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Minibus{");
        sb.append("ID=").append(getMinibusId());
        sb.append(", ").append(super.toString());
        sb.append(", priceHour=").append(getPriceHour());
        sb.append('}');
        return sb.toString();
    }
}
