package Lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LambdaAnimal> animals = new ArrayList<>();
        animals.add(new LambdaAnimal("fish", false, true));
        animals.add(new LambdaAnimal("kangaroo", true, true));
        animals.add(new LambdaAnimal("rabbit", true, false));
        animals.add(new LambdaAnimal("turtle", false, true));

        print(animals, a -> a.isCanSwim());
    }

    private static void print(List<LambdaAnimal> animals, CheckTrait checker) {
        for (LambdaAnimal animal : animals) {
            if (checker.test(animal)) System.out.print(animal + " ");
        }
            System.out.println();
        }
    }
