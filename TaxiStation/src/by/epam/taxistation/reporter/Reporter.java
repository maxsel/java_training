package by.epam.taxistation.reporter;

import by.epam.taxistation.entity.TaxiStation;

public interface Reporter {

    void open(String path);

    void print(TaxiStation taxiStation);

    void print(String s);

    void close();
}
