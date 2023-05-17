package Draft;

public class Main {
    public static void main(String[] args) {
        String s1 = new String("1");
        String s2 = s1.concat("2");
        System.out.println(s2);
        s2 += "3";
        System.out.println(s2);
    }
}
