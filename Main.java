public class Main
{
    public static void main(String[] args)
    {
        BST<Integer, Integer> tree = new BST<>();
        tree.put(254, 1);
        tree.put(228, 2);
        tree.put(133, 3);
        tree.put(700, 4);
        tree.put(121, 5);
        tree.put(655, 6);
        tree.put(324, 7);
        tree.put(422, 8);
        System.out.println(tree.get(422));
    }
}
