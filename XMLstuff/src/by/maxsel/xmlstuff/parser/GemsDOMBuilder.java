package by.maxsel.xmlstuff.parser;

import by.maxsel.xmlstuff.entity.Gem;
import by.maxsel.xmlstuff.entity.PrivateGem;
import by.maxsel.xmlstuff.entity.RussianGem;
import by.maxsel.xmlstuff.entity.VisualParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class GemsDOMBuilder extends AbstractGemsBuilder {
    private DocumentBuilder docBuilder;

    public GemsDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public GemsDOMBuilder (Set<Gem> gems) {
        super(gems);
        // more code
    }

    @Override
    public void buildSetGems(String fileName) {
        Document doc = null;
        try {
            // parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <gem>
            NodeList gemsList = root.getElementsByTagName("russian-gem");
            for (int i = 0; i < gemsList.getLength(); i++) {
                Element gemElement = (Element) gemsList.item(i);
                RussianGem gem = buildRussianGem(gemElement);
                gems.add(gem);
            }
            gemsList = root.getElementsByTagName("private-gem");
            for (int i = 0; i < gemsList.getLength(); i++) {
                Element gemElement = (Element) gemsList.item(i);
                PrivateGem gem = buildPrivateGem(gemElement);
                gems.add(gem);
            }
            /*
            NodeList allNodes = root.getChildNodes();
            for (int i = 0; i < allNodes.getLength(); i++) {
                Element elem = (Element) allNodes.item(i);
                if ("russian-gem".equals(elem.getLocalName())) {
                    RussianGem gem = buildRussianGem(elem);
                    gems.add(gem);
                } else if ("private-gem".equals(elem.getLocalName())) {
                    PrivateGem gem = buildPrivateGem(elem);
                    gems.add(gem);
                }
            }
            */
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private RussianGem buildRussianGem(Element gemElement) {
        RussianGem gem = new RussianGem();
        buildGem(gemElement, gem);
        gem.setPurchaseYear(new BigInteger(getElementTextContent(gemElement, "purchase-year")));
        return gem;
    }

    private PrivateGem buildPrivateGem(Element gemElement) {
        PrivateGem gem = new PrivateGem();
        buildGem(gemElement, gem);
        gem.setOwner(getElementTextContent(gemElement, "owner"));
        return gem;
    }

    private void buildGem(Element gemElement, Gem gem) {
        //Gem gem = new Gem();
        gem.setVisualParameters(new VisualParameters());
        // заполнение объекта gem
        gem.setId(gemElement.getAttribute("id"));
        gem.setTitle(gemElement.getAttribute("title"));
        gem.setName(getElementTextContent(gemElement, "name"));
        gem.setPreciousness(getElementTextContent(gemElement, "preciousness"));
        gem.setOrigin(getElementTextContent(gemElement, "origin"));

        VisualParameters vp = gem.getVisualParameters();
        // заполнение объекта vp
        Element vpElement = (Element) gemElement.getElementsByTagName(
                "visual-parameters").item(0);
        vp.setColor(getElementTextContent(vpElement, "color"));
        vp.setOpacity(Integer.valueOf(getElementTextContent(vpElement, "opacity")));
        vp.setCutType(Integer.valueOf(getElementTextContent(vpElement, "cut-type")));

        gem.setValue(Double.valueOf(getElementTextContent(gemElement, "value")));
        //return gem;
    }

    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
