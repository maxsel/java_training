package by.epam.composite.main;

import by.epam.composite.action.SentencesByWordsCountSorter;
import by.epam.composite.action.UniqueWordsFinder;
import by.epam.composite.component.Composite;
import by.epam.composite.exception.ParseException;
import by.epam.composite.parser.TextParser;
import by.epam.composite.util.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by maxsel on 16.12.15.
 */
public class Main {
    // TODO: add chain of resp.
    // TODO: add two more functions
    public final static Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("./resources/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        String text;
        try {
            text = FileUtils.readFile("./resources/text.txt", Charset.defaultCharset());
            Composite parsedText = TextParser.parseText(text);
            LOG.debug(parsedText + "\n");
            LOG.debug("\nSentences sorted by words count:\n");
            SentencesByWordsCountSorter.sort(parsedText).forEach(LOG::debug);
            LOG.debug("\nUnique words from the first sentence:\n");
            UniqueWordsFinder.find(parsedText).forEach(LOG::debug);
        } catch (IOException | ParseException e) {
            LOG.error(e);
        }
    }
}
