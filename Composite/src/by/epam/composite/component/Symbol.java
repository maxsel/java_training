package by.epam.composite.component;

/**
 * Created by Maxim Selyuk on 16.12.15.
 */
public class Symbol implements Component {
    private char value;

    public Symbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return getValue() == symbol.getValue();
    }

    @Override
    public int hashCode() {
        return (int) getValue();
    }

    @Override
    public String toString() {
        return Character.toString(getValue());
    }
}
