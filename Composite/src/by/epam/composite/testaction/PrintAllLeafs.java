package by.epam.composite.testaction;

import by.epam.composite.component.Component;
import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;
import org.apache.log4j.Logger;

/**
 * Created by maxsel on 21.12.15.
 */
public class PrintAllLeafs {

    public final static Logger LOG = Logger.getLogger(PrintAllLeafs.class);

    static {
        LOG.debug("\n\nLeafs:\n");
    }

    public static void print(Component comp) {
        if (comp.getType() == ComponentType.LISTING) {
            LOG.debug("Leaf " + comp.getType() + ":\n" + comp + "---");
        } else if (comp.getType() == ComponentType.SYMBOL) {
            LOG.debug("Leaf " + comp.getType() + ": " + comp);
        } else {
            Composite composite = (Composite)comp;
            for (Component child : composite) {
                print(child);
            }
        }
    }
}
