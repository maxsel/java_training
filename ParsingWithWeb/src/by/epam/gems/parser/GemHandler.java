package by.epam.gems.parser;

import by.epam.gems.entity.Gem;
import by.epam.gems.entity.PrivateGem;
import by.epam.gems.entity.RussianGem;
import by.epam.gems.entity.VisualParameters;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigInteger;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class GemHandler extends DefaultHandler {

    private Set<Gem> gems;
    private Gem current;
    private GemEnum currentEnum;
    private EnumSet<GemEnum> withText;

    public GemHandler() {
        gems = new HashSet<>();
        withText = EnumSet.range(GemEnum.NAME, GemEnum.OWNER);
    }

    public Set<Gem> getGems() {
        return gems;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("russian-gem".equals(localName)) {
            current = new RussianGem();
            current.setVisualParameters(new VisualParameters());
            current.setId(attrs.getValue(0));
            if (attrs.getLength() == 2) { // title has default value
                current.setTitle(attrs.getValue(1));
            }
        } else if ("private-gem".equals(localName)) {
            current = new PrivateGem();
            current.setVisualParameters(new VisualParameters());
            current.setId(attrs.getValue(0));
            if (attrs.getLength() == 2) { // title has default value
                current.setTitle(attrs.getValue(1));
            }
        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase().replace('-', '_'));
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("russian-gem".equals(localName) || "private-gem".equals(localName)) {
            gems.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case PRECIOUSNESS:
                    current.setPreciousness(s);
                    break;
                case ORIGIN:
                    current.setOrigin(s);
                    break;
                case COLOR:
                    current.getVisualParameters().setColor(s);
                    break;
                case OPACITY:
                    current.getVisualParameters().setOpacity(Integer.valueOf(s));
                    break;
                case CUT_TYPE:
                    current.getVisualParameters().setCutType(Integer.valueOf(s));
                    break;
                case VALUE:
                    current.setValue(Double.valueOf(s));
                    break;
                case PURCHASE_YEAR:
                    RussianGem gem1 = (RussianGem)current;
                    gem1.setPurchaseYear(new BigInteger(s));
                    current = gem1;
                    break;
                case OWNER:
                    PrivateGem gem2 = (PrivateGem)current;
                    gem2.setOwner(s);
                    current = gem2;
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}