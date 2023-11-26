package Blind75;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        Set<ListNode> setOfNodes = new HashSet<>();
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.hasCycle(head);
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> setOfNodes = new HashSet<>();
        while(head!=null){
            if(!setOfNodes.add(head)){
                return false;
            }
            head = head.next;
        }
        return true;
    }


}
