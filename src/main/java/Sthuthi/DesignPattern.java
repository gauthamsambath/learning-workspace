package Sthuthi;

import java.util.*;

public class DesignPattern {

    public static void main(String[] args) {
        List<Integer> listOfInt = new ArrayList<Integer>();
        listOfInt.add(1);
        listOfInt.add(2);

        int[] a = {1,2,3};

        int[] b = {1,2,3};

        int[] arrayOfInt = listOfInt.stream().mapToInt(Integer::intValue).toArray();

        a = listOfInt.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(a[0]);

        // Your code here
        Set<Integer> setOfB = new HashSet<Integer> ();
        for (int i = 0; i < b.length ; i++){
            setOfB.add(b[i]);
        }
        List<Integer> listOfA = new ArrayList<>();
        for (int i = 0; i < a.length ; i++){
            if (!setOfB.contains(a[i])) {
                listOfA.add(a[i]);
            }
        }

        a = listOfA.stream().mapToInt(Integer::intValue).toArray();


    }
}
