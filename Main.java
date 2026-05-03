import java.util.*;

// --- MAIN EXECUTION ---
public class Main {
    public static void main(String[] args) {
        // Part 1.2 Test
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(11);
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(rand.nextInt(100000)), "Value" + i);
        }
        System.out.println("Hashtable Bucket Distribution:");
        table.printBucketSizes();

        System.out.println("\nBST Test:");
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(8, "Eight");

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}