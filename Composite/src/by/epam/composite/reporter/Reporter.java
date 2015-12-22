package by.epam.composite.reporter;

/**
 * Created by Maxim Selyuk on 22.12.15.
 */
public interface Reporter {

    void open();

    void print(String s);

    void close();
}