package Graphs;

import java.util.LinkedList;

public class AdjacencyListImplementationOfGraph {

    public static void main(String[] args) {
        // Create a graph with 5 vertices
        GraphCustom graphCustom = new GraphCustom(5);

        // Add edges
        graphCustom.addEdge(0, 1);
        graphCustom.addEdge(0, 4);
        graphCustom.addEdge(1, 2);
        graphCustom.addEdge(1, 3);
        graphCustom.addEdge(1, 4);
        graphCustom.addEdge(2, 3);
        graphCustom.addEdge(3, 4);

        // Print the graph
        graphCustom.printGraph();
    }
}

class GraphCustom {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public GraphCustom(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Uncomment this line for an undirected graph
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Integer vertex : adjacencyList[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
