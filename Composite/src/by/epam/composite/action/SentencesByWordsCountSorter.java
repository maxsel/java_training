package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.Composite;

import java.util.*;

/**
 * Created by maxsel on 21.12.15.
 */
public class SentencesByWordsCountSorter {
    public static List<Component> sort(Composite composite) {
        // TODO: what to return?
        // TODO: speed up?
        ArrayList<Component> sentences = ComponentHelper.getAllSentences(composite);
        Collections.sort(sentences, (c1, c2) -> ComponentHelper.getAllWords(c1).size() - ComponentHelper.getAllWords(c2).size());
        return sentences;
        //return sentences.stream().map( it -> it.toString()).collect(Collectors.toList()); // if you need strings
    }
}
