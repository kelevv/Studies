package Builder;

public class FordBuilder extends CarBuilder {
    @Override
    void buildMake() {
        car.setMake("Ford");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setTopSpeed(180);
    }
}
