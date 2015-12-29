package by.epam.taxistation.action;

import by.epam.taxistation.comparator.CarByFuelConsumptionComparator;
import by.epam.taxistation.entity.TaxiStation;

public class CarByFuelConsumptionSorter {
    public static void sort(TaxiStation taxiStation) {
        taxiStation.sort(new CarByFuelConsumptionComparator());
    }
}
