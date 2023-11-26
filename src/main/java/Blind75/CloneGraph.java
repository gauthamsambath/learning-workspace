package Blind75;

import Blind75.Domain.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The type Clone graph.
 */
public class CloneGraph {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node3, node1));

        CloneGraph cloneGraph = new CloneGraph();
        Node nodeCloneGraphNode = cloneGraph.cloneGraph(node1);
        if (verifyDeepCopy(node1, nodeCloneGraphNode)) {
            System.out.println("copied correctly");
        } else {
            System.out.println("dont think it is copied correctly");
        }
    }

    /**
     * Verify deep copy boolean.
     *
     * @param original the original
     * @param copy     the copy
     * @return the boolean
     */
    // dont think this function is correct
    public static boolean verifyDeepCopy(Node original, Node copy) {
        if (original == null && copy == null) {
            return true;
        }

        if (original == null || copy == null || original.val != copy.val || original.neighbors.size() != copy.neighbors.size()) {
            return false;
        }

        Map<Node, Node> visited = new HashMap<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(original);
        stack2.push(copy);
        visited.put(original, copy);

        while (!stack1.isEmpty()) {
            Node node1 = stack1.pop();
            Node node2 = stack2.pop();

            for (int i = 0; i < node1.neighbors.size(); i++) {
                Node neighbor1 = node1.neighbors.get(i);
                Node neighbor2 = node2.neighbors.get(i);

                if (!visited.containsKey(neighbor1)) {
                    Node copiedNeighbor = new Node(neighbor1.val);
                    visited.put(neighbor1, copiedNeighbor);
                    stack1.push(neighbor1);
                    stack2.push(copiedNeighbor);
                }

                // Check if the neighbors in the copy graph have been mapped correctly
                if (visited.get(neighbor1) != neighbor2) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Clone graph node.
     *
     * @param node the node
     * @return the node
     */
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNewGraphMapping = new HashMap<>();
        return dfsForCloneGraph(node, oldToNewGraphMapping);
    }

    /**
     * Dfs for clone graph node.
     *
     * @param node                 the node
     * @param oldToNewGraphMapping the old to new graph mapping
     * @return the node
     */
    private Node dfsForCloneGraph(Node node, Map<Node, Node> oldToNewGraphMapping) {
        if (oldToNewGraphMapping.containsKey(node)) {
            return oldToNewGraphMapping.get(node);
        }

        Node copyOfNode = new Node(node.val);
        oldToNewGraphMapping.put(node, copyOfNode);
        for (Node neighbour : node.neighbors) {
            copyOfNode.neighbors.add(dfsForCloneGraph(neighbour, oldToNewGraphMapping));
        }

        return copyOfNode;
    }
}
