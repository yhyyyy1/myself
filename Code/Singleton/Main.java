package Singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        System.out.println("第一种：饿汉");
        VirtualUserGeneratorByHunger hunger1 = VirtualUserGeneratorByHunger.getInstance();
        VirtualUserGeneratorByHunger hunger2 = VirtualUserGeneratorByHunger.getInstance();
        if (hunger1 == hunger2) {
            System.out.println("hunger1和hunger2是相同的实例");
        } else {
            System.out.println("hunger1和hunger2是不同的实例");
        }

        System.out.println("第二种：双重检查锁");
        VirtualUserGeneratorByDoubleJudge doubleJudge1 = VirtualUserGeneratorByDoubleJudge.getInstance();
        VirtualUserGeneratorByDoubleJudge doubleJudge2 = VirtualUserGeneratorByDoubleJudge.getInstance();
        if (doubleJudge1 == doubleJudge2) {
            System.out.println("doubleJudge1和doubleJudge2是相同的实例");
        } else {
            System.out.println("doubleJudge1和doubleJudge2是不同的实例");
        }

        System.out.println("第三种：LODH");
        VirtualUserGeneratorByLODH lodh1 = VirtualUserGeneratorByLODH.getInstance();
        VirtualUserGeneratorByLODH lodh2 = VirtualUserGeneratorByLODH.getInstance();
        if (lodh1 == lodh2) {
            System.out.println("lodh1和lodh2是相同的实例");
        } else {
            System.out.println("lodh1和lodh2是不同的实例");
        }
        System.out.println("End.");
    }
}
