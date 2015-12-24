package by.epam.composite.main;

import by.epam.composite.action.SentencesByWordsCountSorter;
import by.epam.composite.action.UniqueWordsFinder;
import by.epam.composite.action.WordsByVowelRatioSorter;
import by.epam.composite.parser.ChainTextParser;
import by.epam.composite.component.Component;
import by.epam.composite.component.Composite;
import by.epam.composite.exception.CompositeParseException;
import by.epam.composite.reporter.FileReporter;
import by.epam.composite.reporter.Reporter;
import by.epam.composite.util.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.util.List;

/**
 * Created by Maxim Selyuk on 16.12.15.
 */
public class Main {
    public static final Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("./resources/log4j.xml",
                LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        String text;
        try {
            text = FileUtils.readFile("./input/text.txt");
            Composite parsedText = ChainTextParser.parse(text);

            Reporter reporter = new FileReporter();
            reporter.open("./output/output.txt");
            reporter.print(parsedText + "\n");

            reporter.print("\n(#2) SENTENCES SORTED BY WORDS COUNT:\n");
            List<Component> sentencesSorted =
                    SentencesByWordsCountSorter.sort(parsedText);
            for (Component sentence : sentencesSorted) {
                reporter.print(sentence.toString());
            }

            reporter.print("\n(#3) UNIQUE WORDS FROM THE FIRST SENTENCE:\n");
            List<Component> uniqueWords = UniqueWordsFinder.find(parsedText);
            for (Component word : uniqueWords) {
                reporter.print(word.toString());
            }

            reporter.print("\n(#7) WORDS SORTED BY VOWELS RATIO:\n");
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
