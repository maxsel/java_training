package by.epam.composite.main;

import by.epam.composite.action.SentencesByWordsCountSorter;
import by.epam.composite.action.UniqueWordsFinder;
import by.epam.composite.action.WordsByVowelRatioSorter;
import by.epam.composite.component.Component;
import by.epam.composite.component.Composite;
import by.epam.composite.exception.CompositeParseException;
import by.epam.composite.parser.TextParser;
import by.epam.composite.reporter.FileReporter;
import by.epam.composite.reporter.Reporter;
import by.epam.composite.util.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;

/**
 * Created by Maxim Selyuk on 16.12.15.
 */
public class Main {
    // TODO: add chain of resp.
    // TODO: change LOG.debug to output to file
    public final static Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("./resources/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        String text;
        try {
            text = FileUtils.readFile("./input/text.txt");
            Composite parsedText = TextParser.parseText(text);

            Reporter reporter = new FileReporter();
            reporter.open();
            reporter.print(parsedText + "\n");

            reporter.print("\n(task #2) SENTENCES SORTED BY WORDS COUNT:\n");
            for (Component sentence : SentencesByWordsCountSorter.sort(parsedText)) {
                reporter.print(sentence.toString());
            }

            reporter.print("\n(task #3) UNIQUE WORDS FROM THE FIRST SENTENCE:\n");
            for (Component word : UniqueWordsFinder.find(parsedText)) {
                reporter.print(word.toString());
            }

            reporter.print("\n(task #7) WORDS SORTED BY VOWELS RATIO:\n");
            for (Component word : WordsByVowelRatioSorter.sort(parsedText)) {
                reporter.print(word.toString());
            }

            reporter.close();
        } catch (CompositeParseException e) {
            LOG.error(e);
        } catch (IOException e) {
            LOG.fatal(e);
        }
    }
}
