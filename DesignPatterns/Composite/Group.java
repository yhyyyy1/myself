package Composite;

import java.util.ArrayList;
import java.util.List;

public class Group extends Component {
    private List<Component> components = new ArrayList<>();

    public Group(String name) {
        super(name);
    }

    @Override
    public void shareInformation(String information) {
        System.out.println(name + " shared information: " + information + " with all group members.");
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
        System.out.println("Group: " + name);
        for (Component component : components) {
            component.display();
        }
    }
}