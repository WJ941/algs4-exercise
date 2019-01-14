package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise19
{
    public static void main(String[] args)
    {
        BinarySearchST<String, Integer> st = new BinarySearchST<>(200000);
        while (!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word)+1);
        }

        int max = 0;
        for (String word : st.keys())
            if (st.get(word) > max)
                max = st.get(word);
        StdOut.println(max);
        Queue<String> q = new Queue<>();
        for (String word : st.keys())
            if (st.get(word) == max)
                q.enqueue(word);
            for (String word : q)
                StdOut.println(word);
    }
}
