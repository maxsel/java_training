package by.epam.composite.component;

/**
 * Created by Maxim Selyuk on 16.12.15.
 */
public class Listing implements Component {
    private String content;

    public Listing(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.LISTING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Listing listing = (Listing) o;

        return getContent().equals(listing.getContent());

    }

    @Override
    public int hashCode() {
        return getContent().hashCode();
    }

    @Override
    public String toString() {
        return getContent();
    }
}
