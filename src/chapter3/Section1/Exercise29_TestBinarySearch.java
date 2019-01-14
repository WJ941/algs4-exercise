package chapter3.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise29_TestBinarySearch
{
    public static void testMin()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        assert st.min() == null : "min test 1 failed";
        st.put("A", 0);
        assert st.min().equals("A") : "min test 2 failed";
        st.put("B", 0);
        assert st.min().equals("A") : "min test 3 failed";
        StdOut.println("min() test passed.");
    }


    public static void testMax()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        assert st.max() == null : "max test 1 failed";
        st.put("A", 0);
        assert st.max().equals("A") : "max test 2 failed";
        st.put("D", 0);
        assert st.max().equals("D") : "max test 3 failed";
        st.put("B", 0);
        assert st.max().equals("D") : "max test 4 failed";
        StdOut.println("max() test passed.");
    }
    public static void testFloor()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        assert st.floor("A") == null : "floor test 1 failed";
        st.put("A", 0);
        st.put("D", 0);
        st.put("B", 0);
        assert st.floor("1") == null : "floor test 2 failed";
        assert st.floor("A").equals("A") : "floor test 3 failed";
        assert st.floor("B").equals("B") : "floor test 4 failed";
        assert st.floor("C").equals("B") : "floor test 5 failed";
        assert st.floor("H").equals("D") : "floor test 6 failed";
        StdOut.println("floor() test passed.");
    }

    public static void testCeiling()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        assert st.ceiling("A") == null : "ceiling test 1 failed";
        st.put("A", 0);
        st.put("D", 0);
        st.put("B", 0);
        assert st.ceiling("1").equals("A") : "ceiling test 2 failed";
        assert st.ceiling("A").equals("A") : "ceiling test 3 failed";
        assert st.ceiling("B").equals("B") : "ceiling test 4 failed";
        assert st.ceiling("C").equals("D") : "ceiling test 5 failed";
        assert st.ceiling("H") == null : "ceiling test 6 failed";
        StdOut.println("ceiling() test passed.");
    }

    public static void testSelect()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        assert st.select(0) == null : "select test 1 failed";
        st.put("A", 0);
        st.put("D", 0);
        st.put("B", 0);
        assert st.select(0).equals("A") : "select test 2 failed";
        assert st.select(2).equals("D") : "select test 3 failed";
        assert st.select(3) == null : "select test 4 failed";
        StdOut.println("select() test passed.");
    }

    public static void testRank()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        assert st.rank("A") == 0 : "rank test 1 failed";
        st.put("A", 0);
        st.put("D", 0);
        st.put("B", 0);
        assert st.rank("A") == 0 : "rank test 2 failed";
        assert st.rank("B") == 1: "rank test 3 failed";
        assert st.rank("C") == 2 : "rank test 4 failed";
        assert st.rank("D") == 2 : "rank test 5 failed";
        assert st.rank("H") == 3 : "rank test 5 failed";
        StdOut.println("rank() test passed.");
    }
    public static void testDeleteMin()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        st.deleteMin();
        st.put("A", 0);
        st.deleteMin();
        for (String key : st.keys())
            StdOut.println("deleteMin test 1 failed");
        st.put("D", 0);
        st.put("B", 0);
        st.deleteMin();
        for (String key : st.keys())
            assert key.equals("D") : "deleteMin test 2 failed";
        StdOut.println("deleteMin() test passed.");
    }
    public static void testDeleteMax()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        st.deleteMax();
        st.put("A", 0);
        st.deleteMax();
        for (String key : st.keys())
            StdOut.println("deleteMax test 1 failed");
        st.put("D", 0);
        st.put("B", 0);
        st.deleteMax();
        for (String key : st.keys())
            assert key.equals("B") : "deleteMax test 2 failed";
        StdOut.println("deleteMax() test passed.");
    }

    public static void testKeys()
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        for (String key : st.keys())
            StdOut.println("keys test 1 failed");
        st.put("A", 0);
        for (String key : st.keys())
            assert key.equals("A") : "keys test 2 failed";
        st.put("D", 0);
        st.put("B", 0);
        String[] keys = {"A", "B", "D"};
        int i = 0;
        for (String key : st.keys())
            assert key.equals(keys[i++]) : "keys test 3 failed";
        StdOut.println("keys() test passed.");
    }
    public static void main(String[] args)
    {
        testMin();
        testMax();
        testFloor();
        testCeiling();
        testSelect();
        testRank();
        testDeleteMin();
        testDeleteMax();
        testKeys();
    }
}
