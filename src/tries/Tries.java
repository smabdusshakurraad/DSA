package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tries {
    public static int ALPHABET_SIZE = 26;
    private class TrieNode{
        private char value;
        private Map<Character, TrieNode> childs = new HashMap<>();
        private boolean isEndOfWord;
        public TrieNode(char value){
            this.value = value;
        }

        public boolean hasChild(char ch){
            return childs.containsKey(ch);
        }

        public void add(char ch){
            childs.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch){
            return childs.get(ch);
        }

        public boolean hasChildrens(){
            return !childs.isEmpty();
        }

        public TrieNode[] getAllChildren(){
            return childs.values().toArray(new TrieNode[0]);
        }
        @Override
        public String toString() {
            return "value=" + value;
        }

        public void removeChild(char ch) {
            childs.remove(ch);
        }
    }
    private TrieNode root = new TrieNode(' ');
    public void insert(String value){
        var current = root;
        for(char ch : value.toCharArray()){
            if(!current.hasChild(ch))
                current.add(ch);

            current = current.getChild(ch);
        }

        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if(word == null)
            return false;

        var current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChildrens())
                return false;

            if(!current.hasChild(ch))
                return false;


            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(TrieNode root) {
        System.out.println(root.value);

        for(TrieNode child : root.getAllChildren()){
            preOrderTraversal(child);
        }
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TrieNode root) {
        for(TrieNode child : root.getAllChildren()){
            postOrderTraversal(child);
        }

        System.out.println(root.value);
    }

    public void remove(String word) {
        if(word == null)
            return;
        remove(word, root, 0);
    }

    private void remove(String word, TrieNode root, int index) {
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);

        if(child == null)
            return;

        remove(word, child, index + 1);
        if(!child.hasChildrens() && !child.isEndOfWord)
            root.removeChild(ch);
    }


    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        if(prefix == null)
            return words;

        TrieNode lastNodeOfPrefix = findLastNodeOf(prefix);

        findWords(lastNodeOfPrefix, prefix, words);

        return words;
    }

    private void findWords(TrieNode lastNodeOfPrefix, String prefix, List<String> words) {
        if(lastNodeOfPrefix == null)
            return;

        if(lastNodeOfPrefix.isEndOfWord)
            words.add(prefix);


        for(TrieNode child : lastNodeOfPrefix.getAllChildren())
            findWords(child, prefix + child.value, words);

    }

    private TrieNode findLastNodeOf(String prefix) {
        if(prefix == null)
            return null;

        var current = root;
        for(var ch : prefix.toCharArray()){
            var child = current.getChild(ch);

            if(child == null)
                return null;

            current = child;
        }

        return current;
    }

    public boolean containsRecursive(String word){
        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(TrieNode root, String word, int index) {
        if(index == word.length())
            return root.isEndOfWord;

        TrieNode child = root.getChild(word.charAt(index));
        if(child == null)
            return false;

        return containsRecursive(root.getChild(word.charAt(index)), word, index+1);

    }

    public int countWords(){
        return countWords(root, 0);
    }

    private int countWords(TrieNode node, int count) {
        if(node.isEndOfWord)
            count++;

        var childrens = node.getAllChildren();
        for(var child : childrens)
            count = countWords(child, count);

        return count;
    }

}
