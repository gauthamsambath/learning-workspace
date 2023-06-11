package com.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Testing {
    public static void main(String[] args) {
        String expression = "-1/2+1/2";
        String[] operatorArray = Arrays.stream(expression.split("\\d|\\/"))
                .filter(a -> !a.equals(""))
                .collect(Collectors.toList())
                .toArray(new String[0]);
        System.out.println(Arrays.toString(operatorArray));
        int[] a= {1,2,3,4,5};
        AtomicReference<Integer> b = new AtomicReference<>(1);
        Arrays.stream(a).forEach(value->{
            b.updateAndGet(v -> v * value);
        });
        System.out.println(b);
        List<Integer> valList = new ArrayList<>();
        valList.add(2);
        valList.add(3);
        String word1 = "gautham";
        String word2 = "gautham";
        System.out.println(word1 == word2);
        System.out.println(word1.equals(word2));
        word1 = new String("gautham");
        word2 = new String("gautham");
        System.out.println(word1 == word2);
        System.out.println(word1.equals(word2));
        int i =2;
        i = i++;
        System.out.println("i ="+i);
    }
}

class Alpha
{
    static String s = " ";
    protected Alpha()
    {
        s += "alpha ";
    }
}

class SubSubAlpha extends Alpha
{
//    static String s = " ";
    int number = 5;
    static int number2 = 9;
    private SubSubAlpha(int g)
    {
        number++;
        this.number = 4;
        s += "subsub ";
    }
    public static void main(String[] args)
    {
        SubSubAlpha sg1 = new SubSubAlpha(56);
//        SubSubAlpha sg2 = new SubSubAlpha();
        System.out.println(sg1.number);
//        System.out.println(sg2.s);
    }
}
