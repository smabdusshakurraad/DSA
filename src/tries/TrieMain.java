package tries;

public class TrieMain {
    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("car");
        tries.insert("care");

        System.out.println("done");

        System.out.println(tries.contains("ca"));

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
    }

}
