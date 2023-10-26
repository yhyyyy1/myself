package Builder;

public class CarDirector {
    public Car construct(CarBuilder builder) {
        builder.buildBody();
        builder.buildEngine();
        builder.buildTires();
        builder.buildTransmission();
        return builder.getResult();
    }
}
