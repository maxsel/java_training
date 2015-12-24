package by.epam.composite.parser;

import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import by.epam.composite.component.Symbol;
import by.epam.composite.exception.CompositeParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public class LexemeParser extends AbstractParser {
    private static final String WORD = "([A-Za-z-]+)";

    @Override
    public Composite parse(String lexeme) throws CompositeParseException {
        if (successor == null) {
            throw new CompositeParseException("Incomplete chain of parsers");
        }

        Composite parsedLexeme = new Composite(ComponentType.LEXEME);

        Matcher wordMatcher = Pattern.compile(WORD, Pattern.DOTALL)
                                        .matcher(lexeme);
        while (wordMatcher.find()) {
            int start = wordMatcher.start();
            if (start == 0) {
                String word = wordMatcher.group();
                parsedLexeme.addChild(successor.parse(word));
                lexeme = lexeme.substring(wordMatcher.end());
                wordMatcher.reset(lexeme);
            } else {
                parsedLexeme.addChild(new Symbol(lexeme.charAt(0)));
                lexeme = lexeme.substring(1);
                wordMatcher.reset(lexeme);
            }
        }
        for (Character c : lexeme.toCharArray()) {
            parsedLexeme.addChild(new Symbol(c));
        }

        return parsedLexeme;
    }
}
