package by.epam.taxistation.action;

import by.epam.taxistation.entity.Car;
import by.epam.taxistation.entity.TaxiStation;

public class OverallCostOfCarsCounter {
    public static int countCost(TaxiStation taxiStation) {
        int overallCost = 0;
        for (Car c : taxiStation) {
            overallCost += c.getCost();
        }
        return overallCost;
    }
}
