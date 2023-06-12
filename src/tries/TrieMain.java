package tries;

public class TrieMain {
    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("car");
        tries.insert("care");

        System.out.println("done");

        System.out.println("Count: " + tries.countWords());

        System.out.println(tries.contains("ca"));
        System.out.println(tries.contains("car"));
        System.out.println(tries.containsRecursive("ca"));
        System.out.println(tries.containsRecursive("car"));

        System.out.println("Pre Order Traversal");
        tries.preOrderTraversal();
        System.out.println();

        System.out.println("Post Order traversal");
        tries.postOrderTraversal();

        tries.remove(null);
        System.out.println(tries.contains("car"));
        System.out.println(tries.contains("care"));
        System.out.println("done");

        var words = tries.findWords("ca");
        System.out.println(words);


        String[] strings = {"card", "care"};
        String[] strings1 = {"car", "care"};
        String[] strings2 = {"car", "dog"};
        String[] strings3 = {"car"};
        System.out.println("Longest prefix for {\"card\", \"care\"}: " + tries.longestPrefix(strings));
        System.out.println("Longest prefix for {\"car\", \"care\"}: " + tries.longestPrefix(strings1));
        System.out.println("Longest prefix for {\"car\", \"dog\"}: " + tries.longestPrefix(strings2));
        System.out.println("Longest prefix for {\"car\"}: " + tries.longestPrefix(strings3));
    }

}
