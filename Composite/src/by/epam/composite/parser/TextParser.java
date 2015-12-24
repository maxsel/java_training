package by.epam.composite.parser;

import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import by.epam.composite.component.Listing;
import by.epam.composite.exception.CompositeParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public class TextParser extends AbstractParser {
    private static final String PARAGRAPH_OR_LISTING_REGEX =
            "((^\\s\\s\\s\\s(?![^\\n]*//:)[^\\n]+\\n)"
                    + "|(^\\s*//:.*?//:~\\s*\\n))";
    private static final String PARAGRAPH_REGEX =
            "(^\\s\\s\\s\\s(?![^\\n]*//:)[^\\n]+\\n)";
    private static final String LISTING_REGEX = "(^\\s*//:.*?//:~\\s*\\n)";

    @Override
    public Composite parse(String text) throws CompositeParseException {
        if (successor == null) {
            throw new CompositeParseException("Incomplete chain of parsers");
        }
        Composite parsedText = new Composite(ComponentType.TEXT);
        Matcher paragraphOrListing =
                Pattern.compile(PARAGRAPH_OR_LISTING_REGEX, Pattern.DOTALL)
                        .matcher(text);
        Matcher paragraph =
                Pattern.compile(PARAGRAPH_REGEX, Pattern.DOTALL).matcher(text);
        Matcher listing =
                Pattern.compile(LISTING_REGEX, Pattern.DOTALL).matcher(text);
        while (paragraphOrListing.find()) {
            String component = paragraphOrListing.group();
            paragraph.reset(component);
            listing.reset(component);
            if (paragraph.matches()) {
                parsedText.addChild(successor.parse(component));
            } else if (listing.matches()) {
                parsedText.addChild(new Listing(component));
            } else {
                throw new CompositeParseException("Wrong input text format");
            }
            text = text.substring(paragraphOrListing.end());
            paragraphOrListing.reset(text);
        }
        return parsedText;
    }
}
