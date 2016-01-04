package by.maxsel.xmlstuff.main;

import by.maxsel.xmlstuff.entity.Gem;
import by.maxsel.xmlstuff.parser.AbstractGemsBuilder;
import by.maxsel.xmlstuff.parser.GemBuilderFactory;

import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public class Main {
    public static void main(String[] args) {
        GemBuilderFactory sFactory = new GemBuilderFactory();
        AbstractGemsBuilder builder = sFactory.createGemBuilder("dom");
        builder.buildSetGems("data/gems.xml");
        System.out.println(builder.getGems());
        Set<Gem> gems = builder.getGems();
        for (Gem g : gems) {
            System.out.println(g.getId() + ", " + g.getTitle() + ", " + g.getName());
        }
    }
}
