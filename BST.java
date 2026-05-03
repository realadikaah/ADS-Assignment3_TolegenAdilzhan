import java.util.Iterator;
import java.util.Stack;

// --- PART 2: BINARY SEARCH TREE ---
class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size = 0;

    public class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node current, K key, V val) {
        if (current == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(current.key);
        if (cmp < 0) current.left = put(current.left, key, val);
        else if (cmp > 0) current.right = put(current.right, key, val);
        else current.val = val;
        return current;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            private Stack<Node> stack = new Stack<>();

            {
                push(root);
            }

            private void push(Node node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            public boolean hasNext() {
                return !stack.isEmpty();
            }

            public Node next() {
                Node node = stack.pop();
                push(node.right);
                return node;
            }
        };
    }
}
