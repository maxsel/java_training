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
        for (Component c : childComponents) {
            sb.append(c);
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
