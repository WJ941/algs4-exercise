package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise11
{


    public static class BinarySearchST<Key extends Comparable<Key>, Value>
    {
        private Key[] keys;
        private Value[] values;
        private int N;

        private int cmpCount = 0;
        public int getCmpCount() { return cmpCount; }

        public BinarySearchST(int capacity)
        {
            keys = (Key[]) new Comparable[capacity];
            values = (Value[]) new Object[capacity];
        }

        public int size() { return N; }

        public boolean isEmpty() { return N == 0; }

        public Value get(Key key)
        {
            if (isEmpty()) return null;
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0)
                return values[i];
            else
                return null;
        }

        public void put(Key key, Value value)
        {
            int i = rank(key);
            cmpCount++;
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
                cmpCount++;
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
            }
            N--;
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


    public static void main(String[] args)
    {
        String[] keys = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N", };
        BinarySearchST<String, Integer> st = new BinarySearchST<>(20);
        for (int i = 0; i < keys.length; i++)
            st.put(keys[i], i);
        StdOut.println(st.getCmpCount());
    }
}
