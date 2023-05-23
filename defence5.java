public class defence5 extends BST
{
    public static void main(String[] args)
    {
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "1");
        tree.put(2, "2");
        tree.put(-3, "3");
        tree.put(4, "4");
        tree.put(5, "-5");
        tree.put(6, "-4");
        tree.put(7, "5");
        tree.put(8, "-1");
        System.out.println(tree.getHeight());
    }
}
