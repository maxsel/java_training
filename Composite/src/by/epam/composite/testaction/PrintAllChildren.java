package by.epam.composite.testaction;

import by.epam.composite.component.Component;
import by.epam.composite.component.Composite;
import org.apache.log4j.Logger;

/**
 * Created by maxsel on 21.12.15.
 */
public class PrintAllChildren {

    public final static Logger LOG = Logger.getLogger(PrintAllChildren.class);

    public static void print(Composite composite) {
        LOG.debug("\n\nChildren:\n");
        for (Component comp : composite) {
            LOG.debug("Component " + comp.getType() + ":\n" + comp + "\n---\n");
        }
    }
}
