package Factory;

public class Main {
    public static void main(String[] args) {
        WatchMaker watchMaker = new DigitalWatchMaker();
        watchMaker.createWatch().showTime();
    }
}