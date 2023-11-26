package Practising;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Practise1 {

    public static void main(String[] args) {
        Queue<Integer> randomQueue = new LinkedList<>();
        Queue<Integer> arrayDequeue = new ArrayDeque<>();
        Comparator<Integer> comp1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };


    }
}

class employee{
    String employeeName;
    int employeeAge;

}
