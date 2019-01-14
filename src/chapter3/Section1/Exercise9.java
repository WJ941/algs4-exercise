package chapter3.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise9
{
    public static void main(String[] args)
    {
        int minlen = Integer.parseInt(args[0]);
        BinarySearchST<String, Integer> st = new BinarySearchST<>(200000);
        String lastWord = "";
        int numOfProcessed = 0;
        while (!StdIn.isEmpty())
        {
            numOfProcessed++;
            String word = StdIn.readString();
            if (word.length() < minlen) continue;
            if (!st.contains(word))
            {
                st.put(word, 1);
                lastWord = word;
            }
            else
            {
                st.put(word, st.get(word)+1);
                lastWord = word;
            }
        }

        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;

        StdOut.println(max + " " + st.get(max));
        StdOut.println("last word " + lastWord);
        StdOut.println("number of words processed " + numOfProcessed);
    }
}
