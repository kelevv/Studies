package StreamAPI;

public class StreamApiAnimal {
    private final String name;
    private final int age;
    private final Classification classification;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classification=" + classification +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Classification getClassification() {
        return classification;
    }

    public StreamApiAnimal(String name, int age, Classification classification) {
        this.name = name;
        this.age = age;
        this.classification = classification;
    }
}
