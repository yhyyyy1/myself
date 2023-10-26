package Builder;

public class OffRoadCarBuilder implements CarBuilder {
    private Car car = new Car("Off-Road Car Body", "Off-Road Car Engine", "Off-Road Car Tires", "Off-Road Car Transmission");

    @Override
    public void buildBody() {
        car = new Car("Off-Road Car Body", car.getEngine(), car.getTires(), car.getTransmission());
    }

    @Override
    public void buildEngine() {
        car = new Car(car.getBody(), "Off-Road Car Engine", car.getTires(), car.getTransmission());
    }

    @Override
    public void buildTires() {
        car = new Car(car.getBody(), car.getEngine(), "Off-Road Car Tires", car.getTransmission());
    }

    @Override
    public void buildTransmission() {
        car = new Car(car.getBody(), car.getEngine(), car.getTires(), "Off-Road Car Transmission");
    }

    @Override
    public Car getResult() {
        return car;
    }
}
