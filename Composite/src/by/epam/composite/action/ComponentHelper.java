package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;

import java.util.ArrayList;

/**
 * Created by Maxim Selyuk on 21.12.15.
 */
public class ComponentHelper {
    public static ArrayList<Component> getAllWords(Component comp) {
        ArrayList<Component> wordList = new ArrayList<>();
        if (comp.getType() == ComponentType.WORD) {
            wordList.add(comp);
        } else if (comp.getType() == ComponentType.SYMBOL || comp.getType() == ComponentType.LISTING) {
            // do nothing
        } else {
            Composite composite = (Composite)comp;
            for (Component child : composite) {
                wordList.addAll(getAllWords(child));
            }
        }
        return wordList;
    }

    public static ArrayList<Component> getAllSentences(Component comp) {
        ArrayList<Component> sentenceList = new ArrayList<>();
        if (comp.getType() == ComponentType.SENTENCE) {
            sentenceList.add(comp);
        } else if (comp.getType() == ComponentType.SYMBOL || comp.getType() == ComponentType.LISTING) {
            // do nothing
        } else {
            Composite composite = (Composite)comp;
            for (Component child : composite) {
                sentenceList.addAll(getAllSentences(child));
            }
        }
        return sentenceList;
    }
}
