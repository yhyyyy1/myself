package TemplateMethod;

import TemplateMethod.methodAdapter.naiveBayes.naiveBayesAchieve;
import TemplateMethod.methodAdapter.naiveBayes.naiveBayesAdapter;

public class naiveBayesVersion extends dataProcessingTemplate {

    @Override
    public String dataClassification(String data) {
        naiveBayesAdapter naiveBayesAdapter = new naiveBayesAchieve(data);
        return naiveBayesAdapter.naiveBayes();
    }
}
