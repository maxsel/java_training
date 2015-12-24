package by.epam.composite.parser;

import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import by.epam.composite.component.Symbol;
import by.epam.composite.exception.CompositeParseException;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public class WordParser extends AbstractParser {
    @Override
    public Composite parse(String word) throws CompositeParseException {
        Composite parsedWord = new Composite(ComponentType.WORD);
        for (Character c : word.toCharArray()) {
            parsedWord.addChild(new Symbol(c));
        }
        return parsedWord;
    }
}