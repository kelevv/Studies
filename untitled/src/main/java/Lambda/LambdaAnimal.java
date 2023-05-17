package Lambda;

public class LambdaAnimal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public LambdaAnimal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }
    public boolean isCanHop() {return canHop;}
    public boolean isCanSwim() {return canSwim;}

    @Override
    public String toString() {
        return species;
    }
}
