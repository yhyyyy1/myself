package Decorator;

public class ReportGenerator {
    public static void main(String[] args) {
        // 创建基础报表
        BaseReport baseReport = new BaseReport();

        // 创建带表头的报表
        BaseReport reportWithHeader = new HeaderDecorator(baseReport);

        // 创建带表头和表尾的报表
        BaseReport reportWithHeaderAndFooter = new FooterDecorator(reportWithHeader);

        // 生成报表
        reportWithHeaderAndFooter.generateReport();
    }
}
