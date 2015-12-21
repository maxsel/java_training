package by.epam.composite.component;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by maxsel on 16.12.15.
 */
public class Composite implements Component, Iterable<Component> {
    private ArrayList<Component> childComponents = new ArrayList<>();
    private ComponentType type;

    public Composite(ComponentType type) {
        this.type = type;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childComponents.size(); i++) {
            Component child = childComponents.get(i);
            switch (child.getType()) {
                case PARAGRAPH:
                    sb.append("    " + child);
                    if (i != childComponents.size() - 1) {
                        sb.append("\n");
                    }
                    break;
                case SENTENCE:
                case LEXEME:
                    sb.append(child);
                    if (i != childComponents.size() - 1) {
                        sb.append(" ");
                    }
                    break;
                case TEXT:
                case LISTING:
                case WORD:
                case SYMBOL:
                    sb.append(child);
                    break;
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<Component> iterator() {
        return childComponents.iterator();
    }

    public void addChild(Component c) {
        childComponents.add(c);
    }

    public void removeChild(Component c) {
        childComponents.remove(c);
    }
}
