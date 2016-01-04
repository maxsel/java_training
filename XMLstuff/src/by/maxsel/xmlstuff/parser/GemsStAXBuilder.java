package by.maxsel.xmlstuff.parser;

import by.maxsel.xmlstuff.entity.Gem;

import javax.xml.stream.XMLInputFactory;
import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class GemsStAXBuilder extends AbstractGemsBuilder {
    private XMLInputFactory inputFactory;

    public GemsStAXBuilder() {
        // more code
    }

    public GemsStAXBuilder (Set<Gem> gems) {
        super(gems);
        // more code
    }

    @Override
    public void buildSetGems(String fileName) {
        // more code
    }
}
