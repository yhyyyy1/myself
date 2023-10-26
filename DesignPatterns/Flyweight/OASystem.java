package Flyweight;

import java.util.HashMap;
import java.util.Map;

// 抽象享元类
interface Flyweight {
    void operation();
}

// 具体享元类
class ConcreteFlyweight implements Flyweight {
    private String permission;

    public ConcreteFlyweight(String permission) {
        this.permission = permission;
    }

    @Override
    public void operation() {
        System.out.println("Operation for permission: " + permission);
    }
}

// 不共享的具体享元类
class UnsharedConcreteFlyweight implements Flyweight {
    private String permission;

    public UnsharedConcreteFlyweight(String permission) {
        this.permission = permission;
    }

    @Override
    public void operation() {
        System.out.println("Unshared operation for permission: " + permission);
    }
}

// 享元工厂类
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String permission) {
        if (flyweights.containsKey(permission)) {
            return flyweights.get(permission);
        } else {
            Flyweight flyweight = new ConcreteFlyweight(permission);
            flyweights.put(permission, flyweight);
            return flyweight;
        }
    }
}

// 模拟用户权限管理
class PermissionManager {
    private FlyweightFactory flyweightFactory = new FlyweightFactory();

    public void displayUserPermissions(String[] userPermissions) {
        for (String permission : userPermissions) {
            Flyweight flyweight = flyweightFactory.getFlyweight(permission);
            flyweight.operation();
        }
    }
}

public class OASystem {
    public static void main(String[] args) {
        PermissionManager permissionManager = new PermissionManager();

        // 模拟用户权限
        String[] userPermissions = {"PermissionA", "PermissionB", "PermissionA", "PermissionC"};

        permissionManager.displayUserPermissions(userPermissions);

        // 不共享的享元对象
        Flyweight unsharedFlyweight = new UnsharedConcreteFlyweight("UnsharedPermission");
        unsharedFlyweight.operation();
    }
}