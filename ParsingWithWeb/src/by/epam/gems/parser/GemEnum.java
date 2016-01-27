package by.epam.gems.parser;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public enum GemEnum {
    GEMS("gems"),
    RUSSIAN_GEM("russian-gem"),
    PRIVATE_GEM("private-gem"),
    ID("id"),
    TITLE("title"),
    //
    NAME("name"),
    PRECIOUSNESS("preciousness"),
    ORIGIN("origin"),
    COLOR("color"),         //
    OPACITY("opacity"),     //
    CUT_TYPE("cut-type"),   //
    VALUE("value"),
    PURCHASE_YEAR("purchase-year"),
    OWNER("owner"),
    //
    VISUAL_PARAMETERS("visual-parameters");

    private String value;

    GemEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
