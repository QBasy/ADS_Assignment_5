import java.util.Scanner;

public class Main
{
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
}
