package TemplateMethod.methodAdapter.decisionTree;

public class decisionTreeAchieve extends decisionTreeSource implements decisionTreeAdapter {
    public decisionTreeAchieve(String data) {
        super(data);
    }

    @Override
    public String decisionTree() {
        return execDecisionTree();
    }
}
