package Builder;

public class Director {
    CarBuilder builder;

    void setBuilder(CarBuilder b) {
        this.builder = b;
    }

    Car buildCar() {
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}