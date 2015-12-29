package by.epam.taxistation.entity;

import by.epam.taxistation.exception.IllegalSetValueException;
import by.epam.taxistation.utility.IdGenerator;

public class TrailerCar extends Car {
    private int trailerCarId;
    private int priceHour;
    private Trailer trailer;

    public int getTrailerCarId() {
        return trailerCarId;
    }

    @Override
    public int getMaxWeight() {
        return (getTrailer() == null)
                ? super.getMaxWeight()
                : super.getMaxWeight() + getTrailer().getMaxWeight();
    }

    public int getPriceHour() {
        return (getTrailer() == null)
                ? priceHour
                : priceHour + getTrailer().getPriceHour();
    }

    public void setPriceHour(int priceHour) throws IllegalSetValueException {
        if (priceHour >= 0) {
            this.priceHour = priceHour;
        } else {
            throw new IllegalSetValueException("TrailerCar's priceHour" +
                    " cannot be less that 0.");
        }
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public TrailerCar(String registrationIdentifier)
            throws IllegalSetValueException {
        super(registrationIdentifier);
        this.trailerCarId = IdGenerator.generate();
    }

    public TrailerCar(String registrationIdentifier, String make, String model,
                      int year, int cost, String driver, int fuelConsumption,
                      int seatsNumber, int maxWeight, int priceHour,
                      Trailer trailer) throws IllegalSetValueException {
        super(registrationIdentifier, make, model,
                year, cost, driver, fuelConsumption,
                seatsNumber, maxWeight, DrivingLicenceType.CE);
        this.trailerCarId = IdGenerator.generate();
        this.priceHour = priceHour;
        this.trailer = trailer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TrailerCar{");
        sb.append("ID=").append(getTrailerCarId());
        sb.append(", ").append(super.toString());
        sb.append(", priceHour=").append(getPriceHour());
        sb.append(", trailer=").append(getTrailer());
        sb.append('}');
        return sb.toString();
    }
}
