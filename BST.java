public class BST<K extends Comparable<K>, V>
{
    private Node root;
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
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = delete(current.right, smallestValue);
        }
        return current;
    }
    public void put(K key, V value)
    {
    }
    public V get(K key)
    {}
    private Node delete(Node current, V value)
    {
        if (current == null)
        {
            return null;
        }
        if (value < current.value)
    }
    public void delete(K key)
    {
        root = delete(root, key);
    }
    public int findSmallestValue(Node root)
    {
        return root.left == null ? (int) root.value : findSmallestValue(root.left);
    }
    public Iterable<K> iterator()
    {}
}