package TemplateMethod;

import TemplateMethod.methodAdapter.decisionTree.decisionTreeAchieve;
import TemplateMethod.methodAdapter.decisionTree.decisionTreeAdapter;

public class decisionTreeVersion extends dataProcessingTemplate {

    @Override
    public String dataClassification(String data) {
        decisionTreeAdapter decisionTreeAdapter = new decisionTreeAchieve(data);
        return decisionTreeAdapter.decisionTree();
    }
}

