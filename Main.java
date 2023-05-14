public class Main
{
    public static void main(String[] args)
    {
        BST<Integer, Integer> tree = new BST<>();
        tree.put(1, 254);
        tree.put(2, 228);
        tree.put(3, 133);
        tree.put(4, 700);
        tree.put(5, 121);
        tree.put(6, 655);
        tree.put(7, 324);
        tree.put(8, 422);
        System.out.println(tree.get(422));
    }
}
