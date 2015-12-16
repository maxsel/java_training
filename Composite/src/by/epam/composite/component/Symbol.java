package by.epam.composite.component;

/**
 * Created by maxsel on 16.12.15.
 */
public class Symbol implements Component {
    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }

    @Override
    public String toString() {
        return Character.toString(getValue());
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
