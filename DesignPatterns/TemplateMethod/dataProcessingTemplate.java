package TemplateMethod;

public abstract class dataProcessingTemplate {
    public final String readData() {
        return "已经读取数据：模拟数据xx";
    }

    public final String changeFormat(String data) {
        return data + "| 已经更改数据格式";
    }

    public abstract String dataClassification(String data);

    public final String resultDataClassification(String data) {
        return "结果为：" + data;
    }
}

