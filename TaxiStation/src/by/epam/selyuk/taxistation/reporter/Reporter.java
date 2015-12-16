package by.epam.selyuk.taxistation.reporter;

import by.epam.selyuk.taxistation.entity.TaxiStation;

public interface Reporter
{
    void open();

    void print(TaxiStation taxiStation);

    void print(String s);

    void close();
}
