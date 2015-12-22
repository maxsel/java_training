package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim Selyuk on 22.12.15.
 */
public final class ComponentHelper {
    private ComponentHelper() {}

    public static List<Component> getAllSentences(Component comp) {
        return getAllOfType(comp, ComponentType.SENTENCE);
    }

    public static List<Component> getAllWords(Component comp) {
        return getAllOfType(comp, ComponentType.WORD);
    }

    public static List<Component> getAllOfType(Component comp,
                                                    ComponentType type) {
        ArrayList<Component> resultList = new ArrayList<>();
        if (comp.getType() == type) {
            resultList.add(comp);
        } else if (comp.getType() != ComponentType.SYMBOL
                    && comp.getType() != ComponentType.LISTING) {
            Composite composite = (Composite)comp;
            for (Component child : composite) {
                resultList.addAll(getAllOfType(child, type));
            }
        }
        return resultList;
    }
}