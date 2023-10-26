package TemplateMethod.methodAdapter.naiveBayes;

public class naiveBayesSource {
    private String string;

    public naiveBayesSource(String string) {
        this.string = string;
    }

    public String execNaiveBayesSource() {
        //执行朴素贝叶斯分类算法——简单的打印一下就行了
        return string + "| 使用了朴素贝叶斯分类";
    }
}
