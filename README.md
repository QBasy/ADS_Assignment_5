# Assignment 5
### Made with :heart: by Sayat Adilkhanov


---


# Main 🚀 [Link](Main.java)

```java
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Enter your choice:");
            System.out.println("1. Put (key, value)\n2. Get value by key\n3. Remove by key\n4. Check if value exists\n5. Get key by value\n6. Get size of Tree\n7.Get All keys");
            System.out.println("8. Exit");

            int n = scanner.nextInt();
                switch (n) {
                case 1:
                    System.out.println("Enter key:");
                    int key = scanner.nextInt();
                    System.out.println("Enter value:");
                    String value = scanner.next();
                    tree.put(key, value);
                    System.out.println("Value inserted.");
                    break;
                case 2:
                    System.out.println("Enter key:");
                    key = scanner.nextInt();
                    String result = tree.get(key);
                    if (result != null) {
                        System.out.println("Value: " + result);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter key:");
                    key = scanner.nextInt();
                    tree.delete(key);
                    String removedValue = tree.get(key);
                    if (removedValue != null) {
                        System.out.println("Press F to value: " + removedValue);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter value:");
                    value = scanner.next();
                    boolean contains = tree.containsValue(value);
                    System.out.println("Value exists: " + contains);
                    break;
                case 5:
                    System.out.println("Enter value:");
                    value = scanner.next();
                    Integer foundKey = tree.getKey(value);
                    if (foundKey != null) {
                        System.out.println("Key: " + foundKey);
                    } else {
                        System.out.println("No such value.");
                    }
                    break;
                case 6:
                    int size = tree.size();
                    System.out.println("Size equals to: " + size);
                case 7:
                    tree.forEachKey();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Don't be a 🤡");
            }
            System.out.println();
        }
        System.out.println("BYE BYE!");
    }
```

---

# Class MyHashTable 🚀 [Link](MyHashTable.java)

```java
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
    /*
    Methods
    */
}
```

## Method put()

```java
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
```

## Method get()

```java
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
```

## Method getKey()

```java
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
```

## Method delete()

```java
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
```

## Method findSmallestValue()

```java
    public V findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
```

## Method getKey and getKeyRecursive

```java
   
```

## Method equals()

```java
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
```

## Method containsValue()

```java
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
```

## Method int size()

```java
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }
```

---

# Class BSTIterator<K>

```java 
    private class BSTIterator<K> implements Iteratorr<K> {
        private Node current;
        private Stack<Node> stack;
        private Stack<K> keyStack;

        public BSTIterator<K>() {
            current = root;
            stack = new Stack<>();
            keyStack = new Stack<>();
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }
        /*
        Methods...
        */
    }
```


## Method hasNext()

```java
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
```


## Method next()

```java
    @Override
    public K next() {
        if (!hasNext()) {
             throw new NoSuchElementException();
        }
        Node node = stack.pop();
        K key = node.key;
        keyStack.push(key);
        current = node.right;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        return key;
    }
```
    
## Method remove()
```java
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
```

## Interface Iteratorr<E>

```java
    public interface Iteratorr<E>{
        E next();
        boolean hasNext();
        void remove();
    }
```
