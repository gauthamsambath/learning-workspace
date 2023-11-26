package DSAProblems.Queues;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The type Priority queue learning.
 */
public class PriorityQueueLearning {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((x, y) -> {
            return Integer.compare(y, x);
        });

        PriorityQueue<ListNode> listNodePriorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });


        Employee employee1 = new Employee("Gautham", 123);
        Employee employee2 = employee1;
        Employee employee3 = new Employee("Jotaro",321);
        employee1 = employee3;
        employee2.setName("Rahul");
        System.out.println(employee1.getName());
        ListNode node = new ListNode(1);
    }
}

/**
 * The type List node.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Employee {
    String name;
    int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
