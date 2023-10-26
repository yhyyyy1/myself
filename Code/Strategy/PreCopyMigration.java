package Strategy;

public class PreCopyMigration implements MigrationStrategy {
    @Override
    public void migrateVirtualMachine() {
        System.out.println("Performing Pre-Copy virtual machine migration.");
        // 实现预拷贝算法的具体逻辑
    }
}
