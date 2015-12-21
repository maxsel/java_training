package by.epam.composite.testaction;

import by.epam.composite.component.Component;
import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import org.apache.log4j.Logger;

/**
 * Created by maxsel on 21.12.15.
 */
public class PrintAllWords {

    public final static Logger LOG = Logger.getLogger(PrintAllWords.class);

    static {
        LOG.debug("\n\nWords:\n");
    }

    public static void print(Component comp) {
        if (comp.getType() == ComponentType.WORD) {
            LOG.debug(comp.getType() + ": \"" + comp + "\"");
        } else if (comp.getType() == ComponentType.SYMBOL || comp.getType() == ComponentType.LISTING) {
            // do nothing
        } else {
            Composite composite = (Composite)comp;
            for (Component child : composite) {
                print(child);
            }
        }
    }
}
