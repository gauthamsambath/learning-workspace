package SPGlobalProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class TreeSearch {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        root.left = node2;
        root.right = node3;
        root.left.left = node4;
        root.left.right = node5;
        root.right.left = node6;
        root.right.right = node7;
        root.left.left.left = node8;
        root.left.left.right = node9;



        int searchNumber = 10;

        int level = findIfNumberPresentInTreeAndRetrunLevel(root,searchNumber);
        if (level == 0) {
            System.out.println("Number not present");
        }
        else {
            System.out.println("Number present at level "+level);
        }


    }



    private static int findIfNumberPresentInTreeAndRetrunLevel(Node root, int searchNumber) {
        Queue<Node> queueForLevelOrder = new LinkedList<>();
        int level =0;
        queueForLevelOrder.add(root);
        int levelRightNow = 1;
        while (!queueForLevelOrder.isEmpty()){
            List<Integer> listOfNodeData = new ArrayList<>();
            List<Node> listOfNode = new ArrayList<>();
            while (!queueForLevelOrder.isEmpty()){
                listOfNode.add(queueForLevelOrder.peek());
                listOfNodeData.add(queueForLevelOrder.poll().data);
            }

            if (listOfNodeData.contains(searchNumber)) {
                return levelRightNow;
            }

            for (Node tempNode:listOfNode) {
                if (tempNode.left!=null) {
                    queueForLevelOrder.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queueForLevelOrder.add(tempNode.right);
                }
            }
            levelRightNow++;
        }

        return 0;
    }


    public static class Node {
        int data;
        Node left;
        Node right;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
        }
    }
}
