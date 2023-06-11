package com.testing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The type Predicate functional interface testing.
 * <p>
 * Class to check the various implementations and functionalities of Predicate Functional Interface .
 */
public class PredicateFunctionalInterfaceTesting implements Predicate<Integer> {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        PredicateFunctionalInterfaceTesting predicate1 = new PredicateFunctionalInterfaceTesting();
        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer k) {
                return k % 2 == 0;
            }
        };
        Predicate<Integer> predicate3 = (x) -> x == 1;
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        listOfIntegers.stream().filter(predicate1.and(predicate2).or(predicate3)).collect(Collectors.toList()).forEach(a -> {
            System.out.print(a + " ");
        });
    }

    @Override
    public boolean test(Integer t) {
        return t > 3;
    }
}
