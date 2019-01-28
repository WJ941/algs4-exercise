package chapter3.Section2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise33_SelectRankCheck
{

    public static void main(String[] args)
    {
        BST<String, Integer> st = new BST<>();
        int i = 0;
        while (!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            st.put(word, i++);
        }

        for (int j = 0; j < st.size(); j++)
            assert j == st.rank(st.select(j)) : j + " failed ";

        for (String key : st.keys())
            assert key == st.select(st.rank(key)) : key + " failed";

        StdOut.println(" Rank / Select check passed.");
    }

}
