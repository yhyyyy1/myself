package TemplateMethod.methodAdapter.KNN;

public class KNNSource {
    private String string;

    public KNNSource(String string) {this.string = string;}

    public String execKNN() {
        //执行K 最近邻算法——简单的打印一下就行了
        return string + "| 使用了K 最近邻算法";
    }
}
