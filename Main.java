public class Main
{
    public static void main(String[] args)
    {
        BST<Integer, Integer> tree = new BST<>();
        tree.put(1, 254);
        tree.put(2, 228);
        tree.put(3, 133);
        System.out.println(tree.get(254));
        /*for (var elem : tree)
        {
            System.out.println("key is " + elem.key + " and value is " + elem.value);
        }*/
    }
}
