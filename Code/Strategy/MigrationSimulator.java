package Strategy;

public class MigrationSimulator {
    private MigrationStrategy migrationStrategy;

    public void setMigrationStrategy(MigrationStrategy strategy) {
        this.migrationStrategy = strategy;
    }

    public void performMigration() {
        if (migrationStrategy != null) {
            migrationStrategy.migrateVirtualMachine();
        } else {
            System.out.println("No migration strategy selected.");
        }
    }
}