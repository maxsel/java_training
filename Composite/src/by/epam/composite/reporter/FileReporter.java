package by.epam.composite.reporter;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Maxim Selyuk on 22.12.15.
 */
public class FileReporter implements Reporter {
    public static final Logger LOG = Logger.getLogger(FileReporter.class);

    private static PrintWriter out;

    public void open(String path) {
        try {
            File file = new File(path);
            if (file != null) {
                if (!file.exists()) {
                    file.createNewFile();
                }
                out = new PrintWriter(file.getAbsoluteFile());
            }
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    public void print(String s) {
        if (out != null) {
            out.println(s);
        }
    }

    public void close() {
        if (out != null) {
            out.close();
        }
    }
}