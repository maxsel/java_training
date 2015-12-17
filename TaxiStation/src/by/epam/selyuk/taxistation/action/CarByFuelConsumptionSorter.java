package by.epam.selyuk.taxistation.action;

import by.epam.selyuk.taxistation.comparator.CarByFuelConsumptionComparator;
import by.epam.selyuk.taxistation.entity.TaxiStation;

public class CarByFuelConsumptionSorter {
    private static CarByFuelConsumptionComparator comparator = new CarByFuelConsumptionComparator();
    public static void sort(TaxiStation taxiStation) {
        taxiStation.sort(comparator);
    }
}
