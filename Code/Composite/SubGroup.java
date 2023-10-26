package Composite;

import java.util.ArrayList;
import java.util.List;

public class SubGroup extends Component {
    private List<Component> components = new ArrayList<>();

    public SubGroup(String name) {
        super(name);
    }

    @Override
    public void shareInformation(String information) {
        System.out.println(name + " shared information: " + information + " with sub-group members.");
        for (Component component : components) {
            component.shareInformation(information);
        }
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("SubGroup: " + name);
        for (Component component : components) {
            component.display();
        }
    }
}
