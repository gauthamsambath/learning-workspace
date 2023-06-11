package DSAProblems.Queues;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueLearning {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((x,y)->{
            return Integer.compare(y,x);
        });
        queue1.add(5);
        queue1.add(4);
//        queue1.add(-1);
        queue1.add(10);
        queue1.add(2);
        queue1.add(1);
//        System.out.println(queue1);
        while (!queue1.isEmpty()){
            System.out.print(queue1.poll()+" ");
        }
    }
}
