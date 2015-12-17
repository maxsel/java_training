package by.epam.selyuk.taxistation.action;

import by.epam.selyuk.taxistation.entity.Car;
import by.epam.selyuk.taxistation.entity.TaxiStation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverallCostOfCarsCounter {
    public static int countCost(TaxiStation taxiStation) {
        int overallCost = 0;
        for (Car c : taxiStation) {
            overallCost += c.getCost();
        }
        return overallCost;
    }
}
