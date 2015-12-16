package by.epam.selyuk.taxistation.action;

import by.epam.selyuk.taxistation.entity.Car;
import by.epam.selyuk.taxistation.entity.TaxiStation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarsInRangeFinder {
    public static List<Car> findRange(int minWeight, int maxWeight,
                                      int minSeats, int maxSeats, TaxiStation taxiStation) {
        List<Car> resultRange = new ArrayList<>();
        for (Car c : taxiStation)
        {
            if (c.getMaxWeight() >= minWeight && c.getMaxWeight() <= maxWeight
                    && c.getSeatsNumber() >= minSeats && c.getSeatsNumber() <= maxSeats ) {
                resultRange.add(c);
            }
        }
        return Collections.unmodifiableList(resultRange);
    }
}
