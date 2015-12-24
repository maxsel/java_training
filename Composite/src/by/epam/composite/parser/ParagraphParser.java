package by.epam.composite.parser;

import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import by.epam.composite.exception.CompositeParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE =
            "(((?<=\\s)[A-Z]|^[A-Z])"
                    + "([A-Za-z0-9\\s,;:\\+\\-\\*/="
                    + "\\|\\(\\)\\{\\}\\[\\]#_\\^\"@\\$%&'⋅\\\\]"
                    + "|(?<!\\s)\\.(?!\\s))+"
                    + "([\\.\\?!](?=\\s)|[\\.\\?!]$))";

    @Override
    public Composite parse(String paragraph) throws CompositeParseException {
        if (successor == null) {
            throw new CompositeParseException("Incomplete chain of parsers");
        }

        Composite parsedParagraph = new Composite(ComponentType.PARAGRAPH);

        Matcher sentenceMatcher = Pattern.compile(SENTENCE, Pattern.DOTALL)
                                            .matcher(paragraph);
        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group();
            parsedParagraph.addChild(successor.parse(sentence));
        }

        return parsedParagraph;
    }
}
