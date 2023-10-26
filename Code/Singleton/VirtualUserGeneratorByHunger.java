package Singleton;

public class VirtualUserGeneratorByHunger {
    private static final VirtualUserGeneratorByHunger instance = new VirtualUserGeneratorByHunger();

    private VirtualUserGeneratorByHunger() {
        System.out.println("饿汉式单例，生成一个实例");
    }

    public static VirtualUserGeneratorByHunger getInstance() {
        return instance;
    }
}
