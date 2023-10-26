package Adapter.classAdapter;

public class ReuseEncryption extends Encryption implements Reuse {
    //要先继承类 再实现接口
    public ReuseEncryption(String cmd) {
        super(cmd);
    }

    @Override
    public void executeEncryption() {
        encryptionString();
    }
}
