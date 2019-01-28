package chapter3.Section2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise10_Test
{
    public static void main(String[] args)
    {
        BST<String, Integer> st = new BST<>();
        for (int i = 0; !StdIn.isEmpty(); i++)
        {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));
        assert st.min().equals("A") : "Test min() failed.";
        assert st.max().equals("X") : "Test max() failed.";

        assert st.floor("1") == null : "Test floor() 1 failed.";
        assert st.floor("A").equals("A") : "Test floor() 2 failed.";
        assert st.floor("M").equals("M") : "Test floor() 3 failed.";
        assert st.floor("N").equals("M") : "Test floor() 4 failed.";
        assert st.floor("Y").equals("X") : "Test floor() 5 failed.";

        assert st.ceiling("1").equals("A") : "Test ceiling() 1 failed.";
        assert st.ceiling("B").equals("C") : "Test ceiling() 2 failed.";
        assert st.ceiling("Y") == null : "Test ceiling() 3 failed.";

        assert st.select(0).equals("A") : "Test select() 1 failed.";
        assert st.select(3).equals("H") : "Test select() 2 failed.";
        assert st.select(10) == null : "Test select() 3 failed.";

        assert st.rank("1") == 0 : "Test rank() 1 failed.";
        assert st.rank("A") == 0 : "Test rank() 1 failed.";
        assert st.rank("H") == 3 : "Test rank() 2 failed.";
        assert st.rank("Y") == 10 : "Test rank() 3 failed.";

        StdOut.println("delete E");
        st.delete("E");
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));

        StdOut.println("delete max");
        st.deleteMax();
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));

        StdOut.println("delete min");
        st.deleteMin();
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));
    }
}
