package Builder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        System.out.println(director.buildCar().toString());
    }
}
