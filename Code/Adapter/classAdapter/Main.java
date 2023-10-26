package Adapter.classAdapter;

public class Main {
    public static void main(String[] args) {
        String DBProgram = "Select * from Business where BusinessId = 100001";
        Reuse reuse = new ReuseEncryption(DBProgram);
        reuse.executeEncryption();
    }
}
