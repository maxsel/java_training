package by.epam.selyuk.taxistation.comparator;

import by.epam.selyuk.taxistation.entity.Car;

import java.util.Comparator;

public class CarByFuelConsumptionComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return car1.getFuelConsumption() - car2.getFuelConsumption();
    }
}