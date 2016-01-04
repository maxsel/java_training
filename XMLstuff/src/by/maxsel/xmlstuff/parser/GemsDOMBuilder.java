package by.maxsel.xmlstuff.parser;

import by.maxsel.xmlstuff.entity.Gem;

import javax.xml.parsers.DocumentBuilder;
import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class GemsDOMBuilder extends AbstractGemsBuilder {
    private DocumentBuilder docBuilder;

    public GemsDOMBuilder() {
        // more code
    }

    public GemsDOMBuilder (Set<Gem> gems) {
        super(gems);
        // more code
    }

    @Override
    public void buildSetGems(String fileName) {
        // more code
    }
}
