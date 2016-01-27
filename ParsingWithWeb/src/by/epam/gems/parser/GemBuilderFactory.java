package by.epam.gems.parser;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class GemBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public AbstractGemsBuilder createGemBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new GemsDOMBuilder();
            case STAX:
                return new GemsStAXBuilder();
            case SAX:
                return new GemsSAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
