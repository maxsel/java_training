package by.epam.composite.action;

import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import by.epam.composite.component.Listing;
import by.epam.composite.component.Symbol;
import by.epam.composite.exception.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maxsel on 16.12.15.
 */
public class TextParser {
    private static final String PARAGRAPH_OR_LISTING = "((^\\s\\s\\s\\s(?![^\\n]*//:)[^\\n]+\\n)|(^\\s*//:.*?//:~\\s*\\n))";
    private static final String PARAGRAPH = "(^\\s\\s\\s\\s(?![^\\n]*//:)[^\\n]+\\n)";
    private static final String LISTING = "(^\\s*//:.*?//:~\\s*\\n)";
    private static final String SENTENCE = "(((?<=\\s)[A-Z]|^[A-Z])([A-Za-z0-9\\s\\,\\;\\:\\+\\-\\*\\/\\=\\|\\(\\)\\{\\}\\[\\]\\#\\_\\^\\\"\\@\\$\\%\\&\\'\\⋅\\\\]|(?<!\\s)\\.(?!\\s))+([\\.\\?\\!](?=\\s)|[\\.\\?\\!]$))";
    private static final String LEXEME = "(^.+?(?=\\s))|((?<=\\s).+?(?=\\s))|((?<=\\s).+?$)";
    private static final String WORD = "([A-Za-z0-9-]+)";

    public static Composite parseText(String text) throws ParseException {
        Composite parsedText = new Composite(ComponentType.TEXT);

        Matcher paragraphOrListing = Pattern.compile(PARAGRAPH_OR_LISTING, Pattern.DOTALL).matcher(text);
        Matcher paragraph = Pattern.compile(PARAGRAPH, Pattern.DOTALL).matcher("");
        Matcher listing = Pattern.compile(LISTING, Pattern.DOTALL).matcher("");
        while (paragraphOrListing.find()) {
            String component = paragraphOrListing.group();
            paragraph.reset(component);
            listing.reset(component);
            if (paragraph.matches()) {
                parsedText.addChild(parseParagraph(component));
            } else if (listing.matches()) {
                parsedText.addChild(new Listing(component));
            } else {
                throw new ParseException();
            }
            text = text.substring(paragraphOrListing.end());
            paragraphOrListing.reset(text);
        }

        return parsedText;
    }

    private static Composite parseParagraph(String paragraph) {
        Composite parsedParagraph = new Composite(ComponentType.PARAGRAPH);

        Matcher sentenceMatcher = Pattern.compile(SENTENCE, Pattern.DOTALL).matcher(paragraph);
        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group();
            parsedParagraph.addChild(parseSentence(sentence));
        }

        return parsedParagraph;
    }

    private static Composite parseSentence(String sentence) {
        Composite parsedSentence = new Composite(ComponentType.SENTENCE);

        Matcher lexemeMatcher = Pattern.compile(LEXEME, Pattern.DOTALL).matcher(sentence);
        while (lexemeMatcher.find()) {
            String lexeme = lexemeMatcher.group();
            parsedSentence.addChild(parseLexeme(lexeme));
        }

        return parsedSentence;
    }

    private static Composite parseLexeme(String lexeme) {
        Composite parsedLexeme = new Composite(ComponentType.LEXEME);

        Matcher wordMatcher = Pattern.compile(WORD, Pattern.DOTALL).matcher(lexeme);
        while (wordMatcher.find()) {
            int start = wordMatcher.start();
            if (start == 0) {
                String word = wordMatcher.group();
                parsedLexeme.addChild(parseWord(word));
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

    private static Composite parseWord(String word) {
        Composite parsedWord = new Composite(ComponentType.WORD);
        for (Character c : word.toCharArray()) {
            parsedWord.addChild(new Symbol(c));
        }
        return parsedWord;
    }
}
