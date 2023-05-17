package Exceptions;

public class Main {
    void explore() {
        try {
            fall();
            System.out.println("Will be never called");
        } catch (Exception e) {
            System.out.println("exception");
            getUp();
        } finally {
            System.out.println("finaly");
        }
    }

    void fall() {
        throw new RuntimeException();
    }

    static void getUp() {
        System.out.println("get up!");
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.explore();
    }
}
