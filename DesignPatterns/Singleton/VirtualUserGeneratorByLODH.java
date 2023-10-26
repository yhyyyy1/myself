package Singleton;

public class VirtualUserGeneratorByLODH {
    private VirtualUserGeneratorByLODH() {
        System.out.println("LODH单例，生成一个实例");
    }

    private static class LODH {
        private static VirtualUserGeneratorByLODH instance = new VirtualUserGeneratorByLODH();
    }

    public static VirtualUserGeneratorByLODH getInstance() {
        return LODH.instance;
    }
}
