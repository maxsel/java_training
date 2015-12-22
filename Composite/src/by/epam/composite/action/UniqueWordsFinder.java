package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.ComponentType;
import by.epam.composite.component.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by maxsel on 21.12.15.
 */
public class UniqueWordsFinder {
    public static List<Component> find(Composite composite) {
        ArrayList<Component> uniqueWords = new ArrayList<>();
        ArrayList<Component> allSentences = ComponentHelper.getAllSentences(composite);

        Composite firstSentence = (Composite)allSentences.get(0);
        ArrayList<Component> firstSentenceWords = ComponentHelper.getAllWords(firstSentence);

        Composite firstSentenceDeleted = new Composite(ComponentType.TEXT);
        allSentences.forEach(firstSentenceDeleted::addChild);
        firstSentenceDeleted.removeChild(firstSentence);

        ArrayList<Component> notFirstSentenceWords = ComponentHelper.getAllWords(firstSentenceDeleted);
        ArrayList<String> notFirstSentenceWordsStringed = notFirstSentenceWords
                                                            .stream()
                                                            .map(Component::toString)
                                                            .collect(Collectors.toCollection(ArrayList::new));

        uniqueWords.addAll(firstSentenceWords
                            .stream()
                            .filter(word -> !notFirstSentenceWordsStringed.contains(word.toString()))
                            .collect(Collectors.toList()));
        return uniqueWords;
    }
}
