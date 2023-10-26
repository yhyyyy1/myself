package Builder;

public class FormulaCarBuilder implements CarBuilder {
    private Car car = new Car("Formula Car Body", "Formula Car Engine", "Formula Car Tires", "Formula Car Transmission");

    @Override
    public void buildBody() {
        car = new Car("Formula Car Body", car.getEngine(), car.getTires(), car.getTransmission());
    }

    @Override
    public void buildEngine() {
        car = new Car(car.getBody(), "Formula Car Engine", car.getTires(), car.getTransmission());
    }

    @Override
    public void buildTires() {
        car = new Car(car.getBody(), car.getEngine(), "Formula Car Tires", car.getTransmission());
    }

    @Override
    public void buildTransmission() {
        car = new Car(car.getBody(), car.getEngine(), car.getTires(), "Formula Car Transmission");
    }

    @Override
    public Car getResult() {
        return car;
    }
}
