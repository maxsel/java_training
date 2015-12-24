package by.epam.composite.parser;

import by.epam.composite.component.Composite;
import by.epam.composite.exception.CompositeParseException;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public class ChainTextParser {
    private static TextParser textParser = new TextParser();

    static {
        ParagraphParser pp = new ParagraphParser();
        SentenceParser sp = new SentenceParser();
        LexemeParser lp = new LexemeParser();
        WordParser wp = new WordParser();

        textParser.setSuccessor(pp);
        pp.setSuccessor(sp);
        sp.setSuccessor(lp);
        lp.setSuccessor(wp);
    }

    public static Composite parse(String text) throws CompositeParseException {
        return textParser.parse(text);
    }

}
