package by.epam.selyuk.taxistation.creator;

import by.epam.selyuk.taxistation.entity.*;
import by.epam.selyuk.taxistation.exception.IllegalSetValueException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Creator {
    /* getting the logger reference */
    public final static Logger LOG = Logger.getLogger(Creator.class);

    /* initializing the logger configuration */
    static {
        new DOMConfigurator().doConfigure("./resources/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static TaxiStation create() {

        TaxiStation taxiStation = new TaxiStation();

        try {
            Taxi taxi1 = new Taxi("AB1234", "Ford", "Victoria", 2000, 35000,
                    "Vasya", 4, 4, 300, 300);

            Taxi taxi2 = new Taxi("UV9805", "Volkswagen", "Golf", 2005, 40000,
                    "Maxim", 3, 5, 200, 300);

            Taxi taxi3 = new Taxi("PK4565", "Volkswagen", "Passat", 2007, 45000,
                    "Igor", 3, 5, 200, 350);

            TaxiLorry lorry1 = new TaxiLorry("RT5687", "KAMAZ", "5320", 1995, 100000,
                    "Dimas", 7, 2, 10000, 2, 700);

            Minibus minibus1 = new Minibus("GH8462", "Mercedes-Benz", "Minibus", 2002, 50000,
                    "Kolyan", 5, 25, 1000, 500);

            Trailer trailer1 = new Trailer("TY5214", "Lada", "Pricep", 2000, 10000, 1000000, 100);

            TrailerCar trailerCar1 = new TrailerCar("RB1112", "Lada", "Kalina", 2008, 30000,
                    "Alex", 4, 4, 750, 200, trailer1);

            taxiStation.addCars(taxi1, taxi2, taxi3, lorry1, minibus1, trailerCar1);

            LOG.debug("Test objects successfully created.");

        } catch (IllegalSetValueException ex) {
            LOG.error("Error when creating test objects.");
        }

        return taxiStation;
    }
}
