package Blind75;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Reverse linked list.
 */
public class ReverseLinkedList {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println("Linked list has " + (checkforReversal(head, reverseLinkedList.reverseListByDuplication(head)) ? "been" : "not been") + " reversed");
    }

    /**
     * Checkfor reversal boolean.
     *
     * @param head        the head
     * @param reverseList the reverse list
     * @return the boolean
     */
    private static boolean checkforReversal(ListNode head, ListNode reverseList) {
        List<ListNode> originalList = getListFromNode(head);
        List<ListNode> reversedList = getListFromNode(reverseList);
        for (int i = 0, j = originalList.size() - 1; i < originalList.size() && j >= 0; i++, j--) {
            if (originalList.get(i).val != reversedList.get(j).val) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets list from node.
     *
     * @param head the head
     * @return the list from node
     */
    private static List<ListNode> getListFromNode(ListNode head) {
        ListNode temp = head;
        List<ListNode> listOfNodes = new ArrayList<>();
        while (temp != null) {
            listOfNodes.add(temp);
            temp = temp.next;
        }
        return listOfNodes;
    }

    /**
     * Reverse list list node.
     *
     * @param head the head
     * @return the list node
     */
    public ListNode reverseList(ListNode head) {
        ListNode tailNode = null;
        ListNode tempHead = head;
        while (tempHead != null) {
            ListNode next = tempHead.next;
            tempHead.next = tailNode;
            tailNode = tempHead;
            tempHead = next;
        }
        return tailNode;
    }

    /**
     * Reverse list list node.
     *
     * @param head the head
     * @return the list node
     */
    public ListNode reverseListByDuplication(ListNode head) {
        ListNode tailNode = null;
        ListNode tempHead = head;
        while (tempHead != null) {
            ListNode temp = new ListNode(tempHead.val, tailNode);
            tailNode = temp;
            tempHead = tempHead.next;
        }
        return tailNode;
    }

}

/**
 * The type List node.
 */
class ListNode {
    /**
     * The Val.
     */
    int val;
    /**
     * The Next.
     */
    ListNode next;

    /**
     * Instantiates a new List node.
     */
    ListNode() {
    }

    /**
     * Instantiates a new List node.
     *
     * @param val the val
     */
    ListNode(int val) {
        this.val = val;
    }

    /**
     * Instantiates a new List node.
     *
     * @param val  the val
     * @param next the next
     */
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}