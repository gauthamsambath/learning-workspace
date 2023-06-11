package Lambdas;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Greeter {

    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("gautham", "sthuthi", "ani");

        Map<Character, List<String>> wordMap = words.stream()
                .collect(Collectors.groupingBy(word ->
                                word.chars()
                                        .mapToObj(c -> (char) c)
                                        .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                                        .entrySet().stream()
                                        .max(Map.Entry.comparingByValue())
                                        .map(Map.Entry::getKey)
                                        .orElse(null),
                        Collectors.toList()));

        // Printing the map
        wordMap.forEach((key, value) ->
                System.out.println(key + " -> " + value));
    }
}
