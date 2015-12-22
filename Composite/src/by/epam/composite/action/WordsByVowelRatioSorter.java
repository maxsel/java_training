package by.epam.composite.action;

import by.epam.composite.component.Component;
import by.epam.composite.component.Composite;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Math;

/**
 * Created by Maxim Selyuk on 23.12.15.
 */
public class WordsByVowelRatioSorter {
    private static List<Character> vowels =
            Arrays.asList('A', 'E', 'I', 'O', 'U');

    public static List<Component> sort(Composite composite) {
        List<Component> words = ComponentHelper.getAllWords(composite);

        return words
                .stream()
                .map(w -> new Pair<>(w, vowelsRatio(w.toString())))
                .sorted((o1, o2) ->
                        (int)Math.signum(o1.getValue() - o2.getValue()))
                .map(Pair::getKey)
                .collect(Collectors.toList());
    }

    private static double vowelsRatio(String word) {
        return (double) word
                    .chars()
                    .mapToObj(x -> (char)x)
                    .filter(c -> vowels.contains(Character.toUpperCase(c)))
                    .count() / word.length();
    }
}
