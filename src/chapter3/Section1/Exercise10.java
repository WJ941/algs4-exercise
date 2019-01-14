package chapter3.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise10
{
    public static class SequentialSearchST<Key, Value>
    {
        private class Node
        {
            public Key key;
            public Value value;
            public Node next;

            public Node(Key key, Value value, Node next)
            {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }
        private Node first;
        private int compareCount = 0;
        public int getCompareCount() { return compareCount; }

        public Value get(Key key)
        {
            for (Node x = first; x != null; x = x.next)
                if (key.equals(x.key))
                    return x.value;
            return null;
        }

        public void put(Key key, Value value)
        {
            for (Node x = first; x != null; x = x.next)
            {
                compareCount++;
                if (key.equals(x.key))
                {
                    x.value = value;
                    return;
                }
            }
            first = new Node(key, value, first);
        }
    }
    public static void main(String[] args)
    {
        String[] keys = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N", };
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        for (int i = 0; i < keys.length; i++)
            st.put(keys[i], i);
        StdOut.println(st.getCompareCount() + " expect " +(1+2+3+4+5+6+4+6+7+8+9));
    }
}
