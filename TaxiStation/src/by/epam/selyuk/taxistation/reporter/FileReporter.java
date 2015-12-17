package by.epam.selyuk.taxistation.reporter;

import by.epam.selyuk.taxistation.entity.TaxiStation;
import by.epam.selyuk.taxistation.main.Main;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReporter implements Reporter
{
    /* getting the logger reference */
    public final static Logger LOG = Logger.getLogger(FileReporter.class);

    private static PrintWriter out;

    public void open() {
        try {
            File file = new File("./output/output.txt"); //exception

            if (!file.exists()) {
                file.createNewFile();
            }

            out = new PrintWriter(file.getAbsoluteFile());
        } catch (IOException | NullPointerException e ) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void print(TaxiStation taxiStation) {
        try {
            out.print(taxiStation);
            out.println();
        } catch (NullPointerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void print(String s) {
        try {
            out.println(s);
        } catch (NullPointerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public void close() {
        try {
            out.close();
        } catch (NullPointerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}