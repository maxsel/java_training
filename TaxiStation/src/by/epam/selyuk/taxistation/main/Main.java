package by.epam.selyuk.taxistation.main;

import by.epam.selyuk.taxistation.action.OverallCostOfCarsCounter;
import by.epam.selyuk.taxistation.action.CarsInRangeFinder;
import by.epam.selyuk.taxistation.action.CarByFuelConsumptionSorter;
import by.epam.selyuk.taxistation.creator.Creator;
import by.epam.selyuk.taxistation.entity.Car;
import by.epam.selyuk.taxistation.entity.TaxiStation;
import by.epam.selyuk.taxistation.reporter.FileReporter;
import by.epam.selyuk.taxistation.reporter.Reporter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.List;

public class Main
{
    /* getting the logger reference */
    public final static Logger LOG = Logger.getLogger(Main.class);

    /* initializing the logger configuration */
    static {
        new DOMConfigurator().doConfigure("./resources/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static void main(String args[])
    {
        LOG.info("Application started.");

        TaxiStation taxiStation = Creator.create();

        Reporter reporter = new FileReporter();

        reporter.open();

        reporter.print("Overall cost of cars in taxi station: "
                + OverallCostOfCarsCounter.countCost(taxiStation) + "\n");

        LOG.info("Overall cost of cars counted.");

        reporter.print("All cars sorted by fuel consumption: \n");
        CarByFuelConsumptionSorter.sort(taxiStation);
        reporter.print(taxiStation);

        LOG.info("Cars sorted.");

        List<Car> carsRange = CarsInRangeFinder.findRange(0, 500, 2, 5, taxiStation);
        reporter.print("\nList of cars in range (" + carsRange.size() + " cars found): \n"
                + carsRange + "\n");

        LOG.info("Cars in range found.");

        reporter.close();

        LOG.info("Application finished.");
    }
}
