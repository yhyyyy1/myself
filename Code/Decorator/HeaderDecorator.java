package Decorator;

public class HeaderDecorator extends ReportDecorator {
    public HeaderDecorator(BaseReport report) {
        super(report);
    }

    @Override
    public void generateReport() {
        System.out.println("Header Content");
        super.generateReport();
    }
}