package Builder;

public class Car {
    private String body;
    private String engine;
    private String tires;
    private String transmission;

    public Car(String body, String engine, String tires, String transmission) {
        this.body = body;
        this.engine = engine;
        this.tires = tires;
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body='" + body + '\'' +
                ", engine='" + engine + '\'' +
                ", tires='" + tires + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }

    public String getEngine() {
        return engine;
    }

    public String getTires() {
        return tires;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getBody() {
        return body;
    }
}
