package Composite;

public class Member extends Component {
    public Member(String name) {
        super(name);
    }

    @Override
    public void shareInformation(String information) {
        System.out.println(name + " shared information: " + information);
    }


    @Override
    public void add(Component component) {
        // 在成员下添加操作不支持
    }

    @Override
    public void remove(Component component) {
        // 从成员中移除操作不支持
    }

    @Override
    public void display() {
        System.out.println("Member: " + name);
    }
}
