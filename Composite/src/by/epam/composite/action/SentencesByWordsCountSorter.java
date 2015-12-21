package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by maxsel on 21.12.15.
 */
public class SentencesByWordsCountSorter {
    public static List<String> sort(Composite composite) {
        ArrayList<Component> sentences = getAllSentences(composite);
        Collections.sort(sentences, (c1, c2) -> getAllWords(c1).size() - getAllWords(c2).size());
        return sentences.stream().map( it -> it.toString()).collect(Collectors.toList());
    }

    private static ArrayList<String> getAllWords(Component comp) {
        ArrayList<String> wordList = new ArrayList<>();
        if (comp.getType() == ComponentType.WORD) {
            wordList.add(comp.toString());
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
