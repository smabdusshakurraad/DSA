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

    public void bfsIterative(String label){
        var root = nodes.get(label);
        if(root == null)
            return;

        Set<Node> visited = new HashSet<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            var current = queue.remove();
            System.out.println(current);
            visited.add(current);

            for(var neighbor : adjacencyList.get(current)){
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                }
            }
        }
    }

    public List<String> topologicalSort(){
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for(var node : nodes.values()){
            topologicalSort(node, visited, stack);
        }

        List<String> sorted = new ArrayList<>();

        while (!stack.isEmpty())
            sorted.add(stack.pop().label);

        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if(visited.contains(node))
            return;

        visited.add(node);

        for (var neighbor : adjacencyList.get(node))
            topologicalSort(neighbor, visited, stack);

        stack.push(node);
    }


    public boolean hasCycle(){
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()){
            var current = all.iterator().next();
            if(hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node current, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(current);
        visiting.add(current);

        for(var neighbour : adjacencyList.get(current)){
            if(visited.contains(neighbour))
                continue;

            if(visiting.contains(neighbour))
                return true;

            if(hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(current);
        visited.add(current);

        return false;

    }
}
