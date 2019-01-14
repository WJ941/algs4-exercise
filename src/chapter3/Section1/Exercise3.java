package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise3
{
    public static class OrderedSequentialST<Key extends Comparable<Key>, Value>
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
        private int N;

        public void put(Key key, Value value)
        {
            if (N == 0)
            {
                first = new Node(key, value, null);
                N++;
                return;
            }
            Node x = null;
            Node y = first;

            while (y != null && y.key.compareTo(key) < 0)
            {
                x = y;
                y = y.next;
            }
            if (x == null)
                first = new Node(key, value, first);
            else
                x.next = new Node(key, value, y);
            N++;
        }

        public Value get(Key key)
        {
            Node x = first;
            while (x != null)
            {
                if (x.key.compareTo(key) == 0)
                    return x.value;
                x = x.next;
            }
            return null;
        }

        public boolean contains(Key key)
        {
            return get(key) != null;
        }

        public boolean isEmpty()
        { return size()  == 0; }

        public int size()
        { return N; }

        public Key min()
        { return first.key; }

        public Key max()
        {
            Node x = first;
            while (x.next != null)
            {
                x = x.next;
            }
            return x.key;
        }

        public Key floor(Key key)
        {
            if (first == null) return null;
            Node x = null;
            Node y = first;
            while (y.key.compareTo(key) <= 0)
            {
                x = y;
                y = y.next;
            }
            if (x == null) return null;
            return x.key;
        }

        public Key ceiling(Key key)
        {
            Node x = first;
            while (x != null && x.key.compareTo(key) < 0)
            {
                x = x.next;
            }
            if (x == null) return null;
            return x.key;
        }

        public int rank(Key key)
        {
            if (first == null) return 0;
            Node x = first;
            int i = 0;
            while (x.key.compareTo(key) < 0)
            {
                i++;
                x = x.next;
            }
            return i;
        }

        public Key select(int k)
        {
            if (k > N) return null;
            Node x = first;
            while (k-- > 0)
            {
                x = x.next;
            }
            return x.key;
        }

        public void deleteMin()
        {
            if (first == null) return;
            first = first.next;
            N--;
        }

        public void deleteMax()
        {
            if (first == null) return;
            if (first.next == null)
            {
                first = null;
                return;
            }
            Node x = null;
            Node y = first;
            while (y.next != null)
            {
                x = y;
                y = y.next;
            }
            x.next = null;
        }

        public Iterable<Key> keys(Key lo, Key hi)
        {
            Queue<Key> q = new Queue<>();
            for ( Node x = first; x != null; x = x.next)
            {
                if (x.key.compareTo(lo) >= 0 &&  x.key.compareTo(hi) <= 0)
                    q.enqueue(x.key);
            }
            return q;
        }

        public Iterable<Key> keys()
        {
            return keys(min(), max());
        }

        public void show()
        {
            StdOut.println("content " + size());
            Node x = first;
            while (x != null)
            {
                StdOut.println(x.key + "  " + x.value);
                x = x.next;
            }
        }

    }
}
