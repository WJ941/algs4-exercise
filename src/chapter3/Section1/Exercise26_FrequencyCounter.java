package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise26_FrequencyCounter
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
        printByKey(st);
        printByFrequency(st);
    }
    public static void printByKey(BinarySearchST<String, Integer> st)
    {
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));
    }
    public static void printByFrequency(BinarySearchST<String, Integer> st)
    {
        class Node implements Comparable<Node>
        {
            private String key;
            private Integer value;
            public Node(String key, Integer value)
            { this.key = key; this.value = value; }

            public int compareTo(Node that)
            {
                return this.value.compareTo(that.value);
            }
        }
        Node[] nodes = new Node[st.size()];
        int i = 0;
        for (String key : st.keys())
            nodes[i++] = new Node(key, st.get(key));
        Arrays.sort(nodes);
        for (i = 0 ; i < nodes.length; i++)
            StdOut.println(nodes[i].key + " " + nodes[i].value);
    }
}
