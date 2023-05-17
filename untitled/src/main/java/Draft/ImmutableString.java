package Draft;

public class ImmutableString {
   private String name;

    public ImmutableString(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
