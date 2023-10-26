package Decorator;


// 表尾装饰器
public class FooterDecorator extends ReportDecorator {
    public FooterDecorator(BaseReport report) {
        super(report);
    }

    @Override
    public void generateReport() {
        super.generateReport();
        System.out.println("Footer Content");
    }
}