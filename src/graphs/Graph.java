package graphs;

import java.util.*;

public class Graph {
    private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if(fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print(){
        for(var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label){
        var node = nodes.get(label);
        if(node == null)
            return;
        for(var n : adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if( fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void dfs(String label){
        var root = nodes.get(label);
        if(root == null)
            return;

        dfs(root, new HashSet<>());
    }

    private void dfs(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);
        for (var child : adjacencyList.get(root)){
            if(!visited.contains(child))
                dfs(child, visited);
        }
    }

    public void dfsIterative(String label){
        var root = nodes.get(label);
        if(root == null)
            return;

        Stack<Node> callStack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        callStack.add(root);

        while (!callStack.isEmpty()){
            var current = callStack.pop();
            System.out.println(current);
            visited.add(current);

            for(var child : adjacencyList.get(current)){
                if(!visited.contains(child))
                    callStack.add(child);
            }

        }
    }
}
