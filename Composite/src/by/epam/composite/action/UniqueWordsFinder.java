package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.Composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maxim Selyuk on 21.12.15.
 */
public class UniqueWordsFinder {
    public static List<Component> find(Composite composite) {
        List<Component> allSentences =
            ComponentHelper.getAllSentences(composite);

        Composite firstSentence = (Composite)allSentences.get(0);
        List<Component> firstSentenceWords =
            ComponentHelper.getAllWords(firstSentence);

        List<Component> tailSentences =
                allSentences.subList(1, allSentences.size());

        ArrayList<Component> tailSentencesWords =
                tailSentences
                        .stream()
                        .flatMap(s -> ComponentHelper.getAllWords(s).stream())
                        .collect(Collectors.toCollection(ArrayList::new));

        HashSet<Component> firstSet = new HashSet<>(firstSentenceWords);
        HashSet<Component> tailSet  = new HashSet<>(tailSentencesWords);
        firstSet.removeAll(tailSet);

        return new ArrayList<>(firstSet);
    }
}
