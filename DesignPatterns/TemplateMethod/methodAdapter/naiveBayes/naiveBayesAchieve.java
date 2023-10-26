package TemplateMethod.methodAdapter.naiveBayes;

public class naiveBayesAchieve extends naiveBayesSource implements naiveBayesAdapter {
    public naiveBayesAchieve(String data) {
        super(data);
    }

    @Override
    public String naiveBayes() {
        return execNaiveBayesSource();
    }
}
