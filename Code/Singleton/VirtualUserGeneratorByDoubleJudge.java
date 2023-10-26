package Singleton;

public class VirtualUserGeneratorByDoubleJudge {
    private volatile static VirtualUserGeneratorByDoubleJudge instance;

    private VirtualUserGeneratorByDoubleJudge() {
        System.out.println("双重检查锁单例，生成一个实例");
    }

    public static VirtualUserGeneratorByDoubleJudge getInstance() {
        if (null == instance) {
            synchronized (VirtualUserGeneratorByDoubleJudge.class) {
                if (null == instance) {
                    instance = new VirtualUserGeneratorByDoubleJudge();
                }
            }
        }
        return instance;
    }
}
