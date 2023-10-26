package Strategy;

public class PostCopyMigration implements MigrationStrategy {
    @Override
    public void migrateVirtualMachine() {
        System.out.println("Performing Post-Copy virtual machine migration.");
        // 实现后拷贝算法的具体逻辑
    }
}