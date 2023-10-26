package TemplateMethod.methodAdapter.KNN;

public class KNNAchieve extends KNNSource implements KNNAdapter {
    public KNNAchieve(String data) {
        super(data);
    }

    @Override
    public String KNN() {
        return execKNN();
    }
}
