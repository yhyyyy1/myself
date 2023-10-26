package Adapter.objectAdapter;

public class Encryption {
    private String string;

    public Encryption(String string) {
        this.string = string;
    }

    public void encryptionString() {
        //对加密进行化简
        System.out.println("已经对数据库操作：\"" + string + "\" 进行了加密");
        System.out.println("对象适配器模式");
    }
}
