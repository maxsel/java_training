package by.epam.composite.parser;

import by.epam.composite.component.Composite;
import by.epam.composite.exception.CompositeParseException;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public abstract class AbstractParser {
    protected AbstractParser successor;

    public void setSuccessor(AbstractParser successor) {
        this.successor = successor;
    }

    public abstract Composite parse(String input)
            throws CompositeParseException;
}
