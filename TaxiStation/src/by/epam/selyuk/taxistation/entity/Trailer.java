package by.epam.selyuk.taxistation.entity;

import by.epam.selyuk.taxistation.exception.IllegalSetValueException;
import by.epam.selyuk.taxistation.utility.IdGenerator;

public class Trailer extends Transport {
    public final int TRAILER_ID = IdGenerator.generate();
    private int maxWeight;
    private int priceHour;

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) throws IllegalSetValueException {
        if (maxWeight >= 0) {
            this.maxWeight = maxWeight;
        } else {
            throw new IllegalSetValueException("Trailer's maxWeight cannot be less that 0.");
        }
    }

    public int getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(int priceHour) throws IllegalSetValueException {
        if (priceHour >= 0) {
            this.priceHour = priceHour;
        } else {
            throw new IllegalSetValueException("Trailer's priceHour cannot be less that 0.");
        }
    }

    public Trailer(String registrationIdentifier) throws IllegalSetValueException {
        super(registrationIdentifier);
    }

    public Trailer(String registrationIdentifier, String make, String model, int year, int cost,
                   int maxWeight, int priceHour)
            throws IllegalSetValueException {
        super(registrationIdentifier, make, model, year, cost);
        setMaxWeight(maxWeight);
        setPriceHour(priceHour);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trailer{");
        sb.append("ID=").append(TRAILER_ID);
        sb.append(", ").append(super.toString());
        sb.append(", maxWeight=").append(getMaxWeight());
        sb.append(", priceHour=").append(getPriceHour());
        sb.append('}');
        return sb.toString();
    }
}
