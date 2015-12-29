package by.epam.taxistation.entity;

import by.epam.taxistation.exception.IllegalSetValueException;

public abstract class Transport {
    private String registrationIdentifier;
    private String make;
    private String model;
    private int year;
    private int cost;

    public String getRegistrationIdentifier() {
        return registrationIdentifier;
    }

    public void setRegistrationIdentifier(String registrationIdentifier)
            throws IllegalSetValueException {
        if ((registrationIdentifier != null
                && !registrationIdentifier.isEmpty())) {
            this.registrationIdentifier = registrationIdentifier;
        } else {
            throw new IllegalSetValueException("Transport's registration ID" +
                    " cannot be null or empty.");
        }
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) throws IllegalSetValueException {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalSetValueException("Transport's cost" +
                    " cannot be less that 0.");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws IllegalSetValueException {
        if (cost >= 0) {
            this.year = year;
        } else {
            throw new IllegalSetValueException("Transport's production year" +
                    " cannot be less that 0.");
        }
    }

    public Transport(String registrationIdentifier)
            throws IllegalSetValueException {
        setRegistrationIdentifier(registrationIdentifier);
    }

    public Transport(String registrationIdentifier, String make, String model,
                     int year, int cost)
            throws IllegalSetValueException{
        setRegistrationIdentifier(registrationIdentifier);
        this.make = make;
        this.model = model;
        setYear(year);
        setCost(cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport)) return false;

        Transport transport = (Transport) o;

        return registrationIdentifier.equals(transport.registrationIdentifier);

    }

    @Override
    public int hashCode() {
        return registrationIdentifier.hashCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("regId=");
        sb.append(registrationIdentifier);
        return sb.toString();
    }
}
