package by.epam.composite.component;

import java.util.ArrayList;

/**
 * Created by maxsel on 16.12.15.
 */
public class Composite implements Component {
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
                case TEXT:
                    sb.append(child.toString());
                    break;
                case LISTING:
                    sb.append(child.toString());
                    break;
                case PARAGRAPH:
                    sb.append("    " + child + "\n");
                    break;
                case SENTENCE:
                    sb.append(child.toString());
                    break;
                case LEXEME:
                    if (i != childComponents.size() - 1) {
                        sb.append(child + " ");
                    } /*else if (i < childComponents.size() - 1) {
                        sb.append(" " + child + " ");
                    }*/ else {
                        sb.append(child + " ");
                    }
                    break;
                case WORD:
                    sb.append(child.toString());
                    break;
                case SYMBOL:
                    sb.append(child.toString());
                    break;
            }
        }
        return sb.toString();
    }

    public void addChild(Component c) {
        childComponents.add(c);
    }

    public void removeChild(Component c) {
        childComponents.remove(c);
    }
}
