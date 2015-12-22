package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.Composite;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Maxim Selyuk on 21.12.15.
 */
public class SentencesByWordsCountSorter {
    public static List<Component> sort(Composite composite) {
        List<Component> sentences = ComponentHelper.getAllSentences(composite);

        return sentences
                .stream()
                .map(s -> new Pair<>(ComponentHelper.getAllWords(s).size(), s))
                .sorted((p1, p2) -> p1.getKey() - p2.getKey())
                .map(Pair::getValue)
                .collect(Collectors.toList());
    }
}
