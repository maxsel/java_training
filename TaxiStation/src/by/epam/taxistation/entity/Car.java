package by.epam.taxistation.entity;

import by.epam.taxistation.exception.IllegalSetValueException;

public abstract class Car extends Transport {
    private String driver;
    private int fuelConsumption;
    private int seatsNumber;
    private int maxWeight;
    private DrivingLicenceType licenceType;

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption)
            throws IllegalSetValueException {
        if (fuelConsumption >= 0) {
            this.fuelConsumption = fuelConsumption;
        } else {
            throw new IllegalSetValueException("Car's fuelConsumption" +
                    " cannot be less that 0.");
        }
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) throws IllegalSetValueException {
        if (maxWeight >= 0) {
            this.maxWeight = maxWeight;
        } else {
            throw new IllegalSetValueException("Car's maxWeight" +
                    " cannot be less that 0.");
        }
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber)
            throws IllegalSetValueException {
        if (seatsNumber >= 0) {
            this.seatsNumber = seatsNumber;
        } else {
            throw new IllegalSetValueException("Car's seatsNumber" +
                    " cannot be less that 0.");
        }
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public DrivingLicenceType getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(DrivingLicenceType licenceType) {
        this.licenceType = licenceType;
    }

    public Car(String registrationIdentifier)
            throws IllegalSetValueException {
        super(registrationIdentifier);
    }

    public Car(String registrationIdentifier, String make, String model,
               int year, int cost, String driver, int fuelConsumption,
               int seatsNumber, int maxWeight, DrivingLicenceType licenceType)
            throws IllegalSetValueException {
        super(registrationIdentifier, make, model, year, cost);
        setDriver(driver);
        setFuelConsumption(fuelConsumption);
        setSeatsNumber(seatsNumber);
        setMaxWeight(maxWeight);
        setLicenceType(licenceType);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(super.toString());
        sb.append(", driver=").append(getDriver());
        sb.append(", fuelConsumption=").append(getFuelConsumption());
        sb.append(", seatsNumber=").append(getSeatsNumber());
        sb.append(", maxWeight=").append(getMaxWeight());
        sb.append(", licenceType=").append(getLicenceType());
        return sb.toString();
    }
}
