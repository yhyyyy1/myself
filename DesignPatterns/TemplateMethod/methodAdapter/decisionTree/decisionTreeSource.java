package TemplateMethod.methodAdapter.decisionTree;

public class decisionTreeSource {
    private String string;

    public decisionTreeSource(String string) {
        this.string = string;
    }

    public String execDecisionTree() {
        //执行决策树——简单的打印一下就行了
        return string + "| 使用了决策树算法";
    }
}
