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
        System.out.println();

        System.out.println("BFS");
        graphTraverse.bfsIterative("A");
        System.out.println();


        System.out.println("Topological Sorting");
        Graph topologicalGraph = new Graph();
        topologicalGraph.addNode("X");
        topologicalGraph.addNode("A");
        topologicalGraph.addNode("B");
        topologicalGraph.addNode("P");
        topologicalGraph.addEdge("X", "A");
        topologicalGraph.addEdge("X", "B");
        topologicalGraph.addEdge("A", "P");
        topologicalGraph.addEdge("B", "P");

        System.out.println(topologicalGraph.topologicalSort());
        System.out.println();

        System.out.println("Cycle detection");
        Graph cycleGraph = new Graph();
        cycleGraph.addNode("A");
        cycleGraph.addNode("B");
        cycleGraph.addNode("C");
        cycleGraph.addNode("D");
        cycleGraph.addEdge("A", "B");
        cycleGraph.addEdge("B", "C");
        cycleGraph.addEdge("A", "C");
        cycleGraph.addEdge("A", "D");
        System.out.println(cycleGraph.hasCycle());
        System.out.println();

        cycleGraph.removeEdge("A", "C");
        cycleGraph.addEdge("C", "A");
        System.out.println(cycleGraph.hasCycle());
    }
}
