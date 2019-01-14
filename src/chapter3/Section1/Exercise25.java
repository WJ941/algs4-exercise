package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;

public class Exercise25
{
    // 增加最近访问的键值
    public class SequentialSearchST<Key, Value>
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
        private Node last;

        public Value get(Key key)
        {
            if (key.equals(last.key)) return last.value;
            for (Node x = first; x != null; x = x.next)
                if (key.equals(x.key))
                {
                    last = new Node(x.key, x.value, null);
                    return x.value;
                }
            return null;
        }

        public void put(Key key, Value value)
        {
            if (key.equals(last.key)) last.value = value;
            for (Node x = first; x != null; x = x.next)
                if (key.equals(x.key))
                {
                    x.value = value;
                    return;
                }
            first = new Node(key, value, first);
        }
    }


    public class BinarySearchST<Key extends Comparable<Key>, Value>
    {
        private Key[] keys;
        private Value[] values;
        private int N;

        private Key lastKey;
        private Value lastValue;

        public BinarySearchST(int capacity)
        {
            keys = (Key[]) new Comparable[capacity];
            values = (Value[]) new Object[capacity];
        }

        public int size() { return N; }

        public boolean isEmpty() { return N == 0; }

        public Value get(Key key)
        {
            if (lastKey != null && lastKey.compareTo(key) == 0) return lastValue;
            if (isEmpty()) return null;
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0)
                return values[i];
            else
                return null;
        }

        public void put(Key key, Value value)
        {
            lastKey = key;
            lastValue = value;
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0)
            { values[i] = value; return; }

            for (int j = N; j > i; j--)
            { keys[j] = keys[j-1]; values[j] = values[j-1];}

            keys[i] = key;
            values[i] = value;
            N++;
        }
        public int rank(Key key)
        {
            int lo = 0; int hi = N - 1;
            while (lo <= hi)
            {
                int mid = (lo + hi) / 2;
                int cmp = keys[mid].compareTo(key);
                if (cmp < 0) lo = mid + 1;
                else if (cmp > 0) hi = mid - 1;
                else return mid;
            }
            return lo;
        }

        public Key min()
        { return keys[0]; }
        public Key max()
        { return keys[N-1]; }
        public Key select(int k)
        { return keys[k]; }

        public Key ceiling(Key key)
        {
            int i = rank(key);
            return keys[i];
        }

        public Key floor(Key key)
        {
            int i = rank(key);
            if (i == 0) return null;
            else return keys[i-1];
        }

        public void delete(Key key)
        {
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0)
            {
                for (int j = i; j < N-1; j++)
                { keys[j] = keys[j+1]; values[j] = values[j+1]; }
                N--;
            }
        }

        public Iterable<Key> keys(Key lo, Key hi)
        {
            Queue<Key> q = new Queue<>();
            for (int i = rank(lo); i < rank(hi); i++)
                q.enqueue(keys[i]);
            if (contains(hi))
                q.enqueue(keys[rank(hi)]);
            return q;
        }
        public Iterable<Key> keys()
        { return keys(keys[0], keys[N-1]);}

        public boolean contains(Key key)
        {
            int i = rank(key);
            return i < N && keys[i].compareTo(key) == 0;
        }
    }
}
