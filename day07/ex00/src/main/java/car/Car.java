package car;

public class Car {
    private String speed;
    private String model;

    public Car(String speed, String model) {
        this.speed = speed;
        this.model = model;
    }

    public Car() {
    }

    public String bee() {
        System.out.println("BEPBEP");
        return "BEP";
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed='" + speed + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
