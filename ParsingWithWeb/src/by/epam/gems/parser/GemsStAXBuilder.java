package by.epam.gems.parser;

import by.epam.gems.entity.Gem;
import by.epam.gems.entity.PrivateGem;
import by.epam.gems.entity.RussianGem;
import by.epam.gems.entity.VisualParameters;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class GemsStAXBuilder extends AbstractGemsBuilder {
    private XMLInputFactory inputFactory;

    public GemsStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public GemsStAXBuilder(Set<Gem> gems) {
        super(gems);
        // more code
    }

    @Override
    public void buildSetGems(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase().replace('-', '_')) == GemEnum.RUSSIAN_GEM) {
                        RussianGem gem = buildRussianGem(reader);
                        gems.add(gem);
                    } else if (GemEnum.valueOf(name.toUpperCase().replace('-', '_')) == GemEnum.PRIVATE_GEM) {
                        PrivateGem gem = buildPrivateGem(reader);
                        gems.add(gem);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private RussianGem buildRussianGem(XMLStreamReader reader) throws XMLStreamException {
        RussianGem gem = new RussianGem();
        gem = (RussianGem)buildGem(reader, gem);
        return gem;
    }

    private PrivateGem buildPrivateGem(XMLStreamReader reader) throws XMLStreamException {
        PrivateGem gem = new PrivateGem();
        gem = (PrivateGem)buildGem(reader, gem);
        return gem;
    }

    private Gem buildGem(XMLStreamReader reader, Gem gem) throws XMLStreamException {
        //Gem gem = new Gem();
        gem.setVisualParameters(new VisualParameters());
        gem.setId(reader.getAttributeValue(null, GemEnum.ID.getValue()));
        gem.setTitle(reader.getAttributeValue(null, GemEnum.TITLE.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case NAME:
                            gem.setName(getXMLText(reader));
                            break;
                        case PRECIOUSNESS:
                            gem.setPreciousness(getXMLText(reader));
                            break;
                        case ORIGIN:
                            gem.setOrigin(getXMLText(reader));
                            break;
                        case VISUAL_PARAMETERS:
                            gem.setVisualParameters(getXMLVisualParameters(reader));
                            break;
                        case VALUE:
                            gem.setValue(Double.valueOf(getXMLText(reader)));
                            break;
                        case PURCHASE_YEAR:
                            RussianGem gem1 = (RussianGem)gem;
                            gem1.setPurchaseYear(new BigInteger(getXMLText(reader)));
                            break;
                        case OWNER:
                            PrivateGem gem2 = (PrivateGem)gem;
                            gem2.setOwner(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase().replace('-', '_')) == GemEnum.PRIVATE_GEM
                            || GemEnum.valueOf(name.toUpperCase().replace('-', '_')) == GemEnum.RUSSIAN_GEM) {
                        return gem;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag" + reader.getLocalName());
    }

    private VisualParameters getXMLVisualParameters(XMLStreamReader reader) throws XMLStreamException {
        VisualParameters vp = new VisualParameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemEnum.valueOf(name.toUpperCase().replace('-', '_'))) {
                        case COLOR:
                            vp.setColor(getXMLText(reader));
                            break;
                        case OPACITY:
                            vp.setOpacity(Integer.valueOf(getXMLText(reader)));
                            break;
                        case CUT_TYPE:
                            vp.setCutType(Integer.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase().replace('-', '_')) ==
                                                    GemEnum.VISUAL_PARAMETERS) {
                        return vp;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag VisualParameters");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
