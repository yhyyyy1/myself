package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        dataProcessingTemplate T1 = new decisionTreeVersion();
        dataProcessingTemplate T2 = new KNNVersion();
        dataProcessingTemplate T3 = new naiveBayesVersion();

        String T1Date = T1.readData();
        String T1DateNewFormat = T1.changeFormat(T1Date);
        String T1DateClassification = T1.dataClassification(T1DateNewFormat);
        String T1Result = T1.resultDataClassification(T1DateClassification);
        System.out.println(T1Result);

        String T2Date = T2.readData();
        String T2DateNewFormat = T2.changeFormat(T2Date);
        String T2DateClassification = T2.dataClassification(T2DateNewFormat);
        String T2Result = T2.resultDataClassification(T2DateClassification);
        System.out.println(T2Result);

        String T3Date = T3.readData();
        String T3DateNewFormat = T3.changeFormat(T3Date);
        String T3DateClassification = T3.dataClassification(T3DateNewFormat);
        String T3Result = T3.resultDataClassification(T3DateClassification);
        System.out.println(T3Result);
    }
}
