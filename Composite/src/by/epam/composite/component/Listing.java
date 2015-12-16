package by.epam.composite.component;

/**
 * Created by maxsel on 16.12.15.
 */
public class Listing implements Component {
    private String content;

    public Listing(String content) {
        this.content = content;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.LISTING;
    }

    @Override
    public String toString() {
        return getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
