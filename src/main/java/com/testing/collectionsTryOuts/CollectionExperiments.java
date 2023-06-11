package com.testing.collectionsTryOuts;

import java.util.*;

public class CollectionExperiments {
    public static void main(String[] args) {
        //List Testing

        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        // Queue Testing
        System.out.println("----- Queue Testing ------");
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new PriorityQueue<>();
        Deque<Integer> queue3 = new ArrayDeque<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(-1);
        Iterator iterator = queue1.iterator();
        while (iterator.hasNext()) {
            System.out.println("value = "+iterator.next());
        }
        int a = queue1.peek();
        System.out.println("a = "+a);
        System.out.println(queue1);

        //Stack Testing
        System.out.println("----- Stack Testing ------");
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(-1);
        while (iterator.hasNext()) {
            System.out.println("value = " + iterator.next());
        }
        System.out.println(stack1.containsAll(queue1));


        //Set testing
        System.out.println("----- Set Testing ------");
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(1);
        set1.addAll(Arrays.asList(1,2,3));
        set2.addAll(Arrays.asList(1,2,3));
        System.out.println(set1);
    }
}
