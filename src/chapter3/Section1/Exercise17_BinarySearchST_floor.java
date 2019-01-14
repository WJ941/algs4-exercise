package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise17_BinarySearchST_floor
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

        public Key floor(Key key) {
            int i = rank(key);
            StdOut.println(i);
            // 1. key 比所有的都大 ： i = N;
            if (i == N) return keys[i - 1];
            // 2.key 小于等于第一个key
            else if (i == 0) return keys[0];
            //
            else if (keys[i].compareTo(key) == 0) return key;
            else return keys[i - 1];
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
    // test floor function
    public static void main(String[] args)
    {
        BinarySearchST<String, Integer> st = new Exercise17_BinarySearchST_floor().new BinarySearchST<>(10);
        st.put("A", 0);
        st.put("C", 2);
        st.put("D", 3);
        st.put("E", 4);

        StdOut.println(st.floor("D")  + " expect D");
        StdOut.println(st.floor("E")  + " expect E");
        StdOut.println(st.floor("F")  + " expect E");
        StdOut.println(st.floor("B")  + " expect A");

        StdOut.println(st.rank("1"));
    }
}
