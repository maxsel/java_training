package by.maxsel.xmlstuff.parser;

import by.maxsel.xmlstuff.entity.Gem;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class GemsSAXBuilder extends AbstractGemsBuilder {
    private GemHandler sh;
    private XMLReader reader;

    public GemsSAXBuilder() {
        // создание SAX-анализатора
        sh = new GemHandler();
        try {
            // создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public GemsSAXBuilder(Set<Gem> gems) {
        super(gems);
        // more code
    }

    @Override
    public void buildSetGems(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }

        gems = sh.getGems();
    }
}
