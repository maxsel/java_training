package by.epam.gems.parser;

import by.epam.gems.entity.Gem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Maxim Selyuk on 04.01.16.
 */
public abstract class AbstractGemsBuilder {
    protected Set<Gem> gems;

    public AbstractGemsBuilder() {
        gems = new HashSet<>();
    }

    public AbstractGemsBuilder(Set<Gem> gems) {
        this.gems = gems;
    }

    public Set<Gem> getGems() {
        return gems;
    }

    abstract public void buildSetGems(String fileName);
}
