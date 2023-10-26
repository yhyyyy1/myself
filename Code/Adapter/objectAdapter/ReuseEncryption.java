package Adapter.objectAdapter;

public class ReuseEncryption extends Reuse {
    private Encryption encryption;

    public ReuseEncryption(String string) {
        this.encryption = new Encryption(string);
    }
    @Override
    public void executeEncryption() {
        encryption.encryptionString();
    }
}
