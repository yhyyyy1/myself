package TemplateMethod;

import TemplateMethod.methodAdapter.KNN.KNNAchieve;
import TemplateMethod.methodAdapter.KNN.KNNAdapter;

public class KNNVersion extends dataProcessingTemplate {
    @Override
    public String dataClassification(String data) {
        KNNAdapter knnAdapter = new KNNAchieve(data);
        return knnAdapter.KNN();
    }
}
