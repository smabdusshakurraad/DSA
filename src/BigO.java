public class BigO {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 10; // constant time O(n)
        System.out.println(array[0]);
        //--------------------------------------
        // O(n + n) = O(2n) = O(n)
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }

        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
        //--------------------------------------
        // O(n + n^2) = O(n^2)
        for (int num : array){ // O(n)
            System.out.println(num);
        }
        // O(n^2)
        for(int first : array){ // O(n)
            for(int second : array){ // O(n)
                System.out.println(first + ", " + second);
            }
        }

        // O(n^3)
        for(int first : array){ // O(n)
            for(int second : array){ // O(n)
                for (int third : array) // O(n)
                    System.out.println(first + ", " + second);
            }
        }

        //---------------------------------------------------------
        // O(log n) -> Binary search takes 19 comparison max to search 1M data
        // Exponential growth is opposite of logarithmic growth and it's not scalable
        // O(2^n) > O(n^2) > O(n) > O(log n)

        int[] copy = new int[array.length]; // O(n) space complexity
    }
}
