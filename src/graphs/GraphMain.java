package graphs;

public class GraphMain {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.removeNode("B");
        graph.print();


        var graphTraverse = new Graph();
        graphTraverse.addNode("A");
        graphTraverse.addNode("B");
        graphTraverse.addNode("C");
        graphTraverse.addNode("D");

        graphTraverse.addEdge("A", "B");
        graphTraverse.addEdge("A", "C");
        graphTraverse.addEdge("B", "D");
        graphTraverse.addEdge("D", "C");

        graphTraverse.dfs("A");
        System.out.println();

        graphTraverse.dfsIterative("A");
    }
}
