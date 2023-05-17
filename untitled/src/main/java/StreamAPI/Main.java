package StreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<StreamApiAnimal> streamApiAnimals = getAnimals();
        //filter
        List<StreamApiAnimal> predators = streamApiAnimals.stream()
                .filter(a -> a.getClassification().equals(Classification.PREDATOR))
                .collect(Collectors.toList());

        predators.forEach(System.out::println);
        //sort
        List<StreamApiAnimal> sortedByAge = streamApiAnimals.stream()
                .sorted(Comparator.comparing(StreamApiAnimal::getAge).reversed()
                        .thenComparing(StreamApiAnimal::getClassification))
                .collect(Collectors.toList());
        sortedByAge.forEach(System.out::println);
        //all match
        System.out.println(
                streamApiAnimals.stream()
                        .allMatch(streamApiAnimal -> streamApiAnimal.getAge() > 10));
        //any match
        System.out.println(
                streamApiAnimals.stream()
                        .anyMatch(streamApiAnimal -> streamApiAnimal.getAge() > 10));
        //none match
        System.out.println(
                streamApiAnimals.stream()
                        .noneMatch(streamApiAnimal -> streamApiAnimal.getName().equalsIgnoreCase("bear")));
        //max
        streamApiAnimals.stream()
                .max(Comparator.comparing(StreamApiAnimal::getAge)).ifPresent(System.out::println);
        //min
        streamApiAnimals.stream()
                .min(Comparator.comparing(StreamApiAnimal::getAge)).ifPresent(System.out::println);
        //group
        Map<Classification, List<StreamApiAnimal>> classificationListMap =
                streamApiAnimals.stream().collect(Collectors.groupingBy(StreamApiAnimal::getClassification));
        classificationListMap.forEach(((classification, animals1) -> {
            System.out.println(classification);
            animals1.forEach(System.out::println);
        }));
        //chaining
        Optional<String> oldestPredator =
        streamApiAnimals.stream()
                .filter(streamApiAnimal -> streamApiAnimal.getClassification().equals(Classification.PREDATOR))
                .max(Comparator.comparing(streamApiAnimal -> streamApiAnimal.getAge()))
                .map(streamApiAnimal -> streamApiAnimal.getName());
        oldestPredator.ifPresent(System.out::println);
    }

    private static List<StreamApiAnimal> getAnimals() {
        return List.of(
                new StreamApiAnimal("Elephant", 20, Classification.HERBIVORE),
                new StreamApiAnimal("Lion", 10, Classification.PREDATOR),
                new StreamApiAnimal("Hyena", 11, Classification.PREDATOR),
                new StreamApiAnimal("Girafe", 7, Classification.HERBIVORE),
                new StreamApiAnimal("Hybon", 35, Classification.OMNIVORUS),
                new StreamApiAnimal("Horse", 36, Classification.HERBIVORE),
                new StreamApiAnimal("Bobcat", 2, Classification.PREDATOR),
                new StreamApiAnimal("Dinosaur", 200, Classification.PREDATOR)
        );
    }
}
