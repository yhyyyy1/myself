package Builder;

public class Main {
    public static void main(String[] args) {
        CarDirector carDirector = new CarDirector();

        Car formulaCar = carDirector.construct(new FormulaCarBuilder());
        System.out.println("Formula Race Car:");
        System.out.println(formulaCar);

        Car offRoadCar = carDirector.construct(new OffRoadCarBuilder());
        System.out.println("\nOff-Road Race Car:");
        System.out.println(offRoadCar);
    }
}
