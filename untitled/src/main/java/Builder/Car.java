package Builder;

enum Transmission {
    AUTO,
    MANUAL;
}

public class Car {
    private String make = "default";
    private int topSpeed = 120;
    private Transmission transmission = Transmission.MANUAL;

    public Car() {
    }

    @Override
    public String toString() {
        return "Builder.Car{" +
                "make='" + make + '\'' +
                ", topSpeed=" + topSpeed +
                ", transmission=" + transmission +
                '}';
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
