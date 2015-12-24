package by.epam.composite.parser;

import by.epam.composite.component.Composite;
import by.epam.composite.exception.CompositeParseException;

/**
 * Created by Maxim Selyuk on 24.12.15.
 */
public abstract class AbstractParser {
    // TODO: weaker (package) class access??
    protected AbstractParser successor;

    public void setSuccessor(AbstractParser successor) {
        this.successor = successor;
    }

    abstract public Composite parse(String input)
            throws CompositeParseException;
}
