package by.epam.composite.parser;

import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import by.epam.composite.exception.CompositeParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public class SentenceParser extends AbstractParser {
    private static final String LEXEME_REGEX =
            "(^.+?(?=\\s))|((?<=\\s).+?(?=\\s))|((?<=\\s).+?$)|(^.+?$)";

    @Override
    public Composite parse(String sentence) throws CompositeParseException {
        if (successor == null) {
            throw new CompositeParseException("Incomplete chain of parsers");
        }
        Composite parsedSentence = new Composite(ComponentType.SENTENCE);
        Matcher lexemeMatcher = Pattern.compile(LEXEME_REGEX, Pattern.DOTALL)
                                        .matcher(sentence);
        while (lexemeMatcher.find()) {
            String lexeme = lexemeMatcher.group();
            parsedSentence.addChild(successor.parse(lexeme));
        }
        return parsedSentence;

    }
}
