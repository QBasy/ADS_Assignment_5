import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V extends Comparable<V>> {
    private Node root;

    public BST() {
        root = null;
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node put(Node current, K key, V value) {
        if (current == null) {
            return new Node(key, value);
        }
        int comparison = key.compareTo(current.key);
        if (comparison < 0) {
            current.left = put(current.left, key, value);
        } else if (comparison > 0) {
            current.right = put(current.right, key, value);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            V smallestValue = findSmallestValue(current.right);
            K keyOfSmallestValue = getKey(smallestValue);
            current.value = smallestValue;
            current.right = delete(current.right, keyOfSmallestValue);
        }
        return current;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        } else {
            int comparison = key.compareTo(node.key);
            if (comparison < 0) {
                return get(node.left, key);
            } else if (comparison > 0) {
                return get(node.right, key);
            } else {
                return node.value;
            }
        }
    }

    public V get(K key) {
        return get(root, key);
    }

    public K getKey(Node node, V value) {
        if (node == null) {
            return null;
        } else {
            int comparison = value.compareTo(node.value);
            if (comparison < 0) {
                return getKey(node.left, value);
            } else if (comparison > 0) {
                return getKey(node.right, value);
            } else {
                return node.key;
            }
        }
    }

    public K getKey(V value) {
        return getKey(root, value);
    }

    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }
        int comparison = key.compareTo(current.key);
        if (comparison < 0) {
            current.left = delete(current.left, key);
        } else if (comparison > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            V smallestValue = findSmallestValue(current.right);
            K keyOfSmallestValue = getKey(smallestValue);
            current.value = smallestValue;
            current.right = delete(current.right, keyOfSmallestValue);
        }
        return current;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    public V findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public BSTIterator iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iteratorr<K> {
        private Node current;
        private Stack<Node> stack;

        public BSTIterator() {
            current = root;
            stack = new Stack<>();
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node node = stack.pop();
            K key = node.key;
            current = node.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            return key;
        }
    }

    public void forEachKey() {
        forEachKey(root);
    }

    private void forEachKey(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            forEachKey(node.left);
            forEachKey(node.right);
        } else {
            System.out.print("Empty ");
        }
    }

    public boolean equals(Node node, V value)
    {
        if (node == null) {
            return false;
        } else {
            int comparison = value.compareTo(node.value);
            if (comparison < 0) {
                return equals(node.left, value);
            } else if (comparison > 0) {
                return equals(node.right, value);
            } else {
                return true;
            }
        }
    }

    public boolean containsValue(V value)
    {
        return containsValue(root, value);
    }
    public boolean containsValue(Node node, V value) {
        if (node == null) {
            return false;
        } else if (equals(node, value)) {
            return true;
        } else {
            return containsValue(node.left, value) || containsValue(node.right, value);
        }
    }
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
}