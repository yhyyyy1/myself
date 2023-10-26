package Decorator;

public abstract class ReportDecorator extends BaseReport {
    private BaseReport report;

    public ReportDecorator(BaseReport report) {
        this.report = report;
    }

    @Override
    public void generateReport() {
        report.generateReport();
    }
}