import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V>
{
    private Node root;

    public BST()
    {
        root = null;
    }
    private class Node
    {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }
    private Node put(Node current, K key, V value)
    {
        if (current == null) {
            return new Node(key, value);
        }
        if ((int) value < (int) current.value)
        {
            current.left = put(current.left, key, value);
        }
        else if ((int) value > (int) current.value)
        {
            current.right = put(current.right, key, value);
        }
        else {
            if (current.left == null && current.right == null) {
                return null;
            }
            ;
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            V smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = delete(current.right, smallestValue);
        }
        return current;
    }
    public void put(K key, V value)
    {
        root = put(root, key, value);
    }
    private V get(Node node)
    {
        if (node != null)
        {
            get(node.left);
            System.out.print(node.value + " ");
            get(node.right);
            System.out.println(node.value + " ");
        }
        return null;
    }
    public V get(K key)
    {
        return get(root);
    }
    private Node delete(Node current, V value)
    {
        if (current == null)
        {
            return null;
        }
        if ((int) value < (int) current.value)
        {
            current.left = delete(current.left, value);
        }
        else if ( (int) value > (int) current.value)
        {
            current.right = delete(current.right, value);
        }
        else
        {
            if (current.left == null && current.right == null)
            {
                System.out.println("LOL THEY ARE EMPTY)))");
                return null;
            }
            if (current.left == null)
            {
                return current.right;
            }
            if (current.right == null)
            {
                return current.left;
            }
            V smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = delete(current.right, smallestValue);
        }
        return current;
    }
    public void delete(V value)
    {
        root = delete(root, value);
    }
    public V findSmallestValue(Node root)
    {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
    public Iterable<K> iterator()
    {
        return (Iterable<K>) new BSTIterator();
    }

    private class BSTIterator implements Iteratorr<K>
    {
        private Node current;
        private Stack<Node> stack;
        public BSTIterator()
        {
            current = root;
            stack = new Stack<>();
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }
        }
        @Override
        public boolean hasNext()
        {
            return !(stack.isEmpty());
        }

        @Override
        public void remove() {

        }

        @Override
        public K next()
        {
            if (!(hasNext()))
            {
                throw new NoSuchElementException();
            }
            Node node = stack.pop();
            K key = node.key;
            current = node.right;
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }
            return key;
        }
    }
    public int size()
    {
        return size(root);
    }
    private int size(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
}
