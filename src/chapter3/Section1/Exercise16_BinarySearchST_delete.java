package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise16_BinarySearchST_delete
{
    public class BinarySearchST<Key extends Comparable<Key>, Value> {
        private Key[] keys;
        private Value[] values;
        private int N;

        public BinarySearchST(int capacity) {
            keys = (Key[]) new Comparable[capacity];
            values = (Value[]) new Object[capacity];
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public Value get(Key key) {
            if (isEmpty()) return null;
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0)
                return values[i];
            else
                return null;
        }

        public void put(Key key, Value value) {
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0) {
                values[i] = value;
                return;
            }

            for (int j = N; j > i; j--) {
                keys[j] = keys[j - 1];
                values[j] = values[j - 1];
            }

            keys[i] = key;
            values[i] = value;
            N++;
        }

        public int rank(Key key) {
            int lo = 0;
            int hi = N - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int cmp = keys[mid].compareTo(key);
                if (cmp < 0) lo = mid + 1;
                else if (cmp > 0) hi = mid - 1;
                else return mid;
            }
            return lo;
        }

        public Key min() {
            return keys[0];
        }

        public Key max() {
            return keys[N - 1];
        }

        public Key select(int k) {
            return keys[k];
        }

        public Key ceiling(Key key) {
            int i = rank(key);
            return keys[i];
        }


        public void delete(Key key) {
            int i = rank(key);
            if (i < N && keys[i].compareTo(key) == 0) {
                for (int j = i; j < N - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                N--;
            }
        }

        public Iterable<Key> keys(Key lo, Key hi) {
            Queue<Key> q = new Queue<>();
            for (int i = rank(lo); i < rank(hi); i++)
                q.enqueue(keys[i]);
            if (contains(hi))
                q.enqueue(keys[rank(hi)]);
            return q;
        }

        public Iterable<Key> keys() {
            if (isEmpty()) return new Queue<>();
            return keys(keys[0], keys[N - 1]);
        }

        public boolean contains(Key key) {
            int i = rank(key);
            return i < N && keys[i].compareTo(key) == 0;
        }
    }

    // test delete function
    public static void main(String[] args)
    {
        BinarySearchST<String, Integer> st = new Exercise16_BinarySearchST_delete().new BinarySearchST<>(10);
        st.put("A", 0);
        StdOut.println(st.get("A"));
        st.delete("A");
        StdOut.println(st.get("A"));
//        st.put("B", 1);
//        st.put("C", 2);

//        StdOut.println("Before delete ");
//        for (String k : st.keys())
//            StdOut.println(k + "  " + st.get(k));
//
//        StdOut.println("After delete B");
//        st.delete("B");
//        for (String k : st.keys())
//            StdOut.println(k + "  " + st.get(k));
//
//        StdOut.println("After delete C");
//        st.delete("C");
//        for (String k : st.keys())
//            StdOut.println(k + "  " + st.get(k));
//
//        StdOut.println("After delete A");
//        st.delete("A");
//        for (String k : st.keys())
//            StdOut.println(k + "  " + st.get(k));
    }
}
