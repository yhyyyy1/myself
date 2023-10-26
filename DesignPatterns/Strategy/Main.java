package Strategy;

public class Main {
    public static void main(String[] args) {
        MigrationSimulator simulator = new MigrationSimulator();

        // 用户选择不同的迁移算法
        simulator.setMigrationStrategy(new PreCopyMigration());
        simulator.performMigration();

        simulator.setMigrationStrategy(new PostCopyMigration());
        simulator.performMigration();

        simulator.setMigrationStrategy(new CRRTMotionMigration());
        simulator.performMigration();
    }
}
