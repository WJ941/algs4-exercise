package chapter2.Section5;

import chapter2.Section4.MinPQ;
import edu.princeton.cs.algs4.StdOut;


public class Exercise24
{
    /**
     * Stable priority queue.
     * @param <key>
     */
    public class MinPQ<key extends Comparable<key>> {
        key[] pq;
        private int size = 0;

        public MinPQ() {
            pq = (key[]) new Comparable[1];
        }

        public MinPQ(int max) {
            pq = (key[]) new Comparable[max + 1];
        }

        public MinPQ(key[] a) {
            int N = a.length;
            size = N;
            pq = (key[]) new Comparable[N + 1];
            for (int i = 0; i < N; i++)
                pq[i + 1] = a[i];
            for (int i = N / 2; i >= 1; i--)
                sink(i);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void insert(key v) {
            if (size >= pq.length / 2) resize(pq.length * 2);
            pq[++size] = v;
            swim(size);
        }

        public key min() {
            return pq[1];
        }

        public key delKey() {
            key min = pq[1];
            exch(1, size--);
            pq[size + 1] = null;
            sink(1);
            if (size <= pq.length / 4) resize(pq.length / 2);
            return min;
        }

        public boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        public void exch(int i, int j) {
            key t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }

        public void swim(int k) {
            while (k > 1 && less(k, k / 2)) {
                exch(k / 2, k);
                k /= 2;
            }
            if (k < size && k % 2 == 0 && pq[k].compareTo(pq[k + 1]) == 0) exch(k, k + 1);
            if (k % 2 == 1  && k > 1 && pq[k].compareTo(pq[k - 1]) == 0) exch(k, k - 1);
        }

        public void sink(int k) {
            while (2 * k <= size) {
                int j = 2 * k;
                if (j < size && less(j + 1, j)) j++;
                if (less(k, j)) break;
                exch(k, j);
                k = j;
            }
        }

        public void resize(int size) {
            key[] t = (key[]) new Comparable[size];
            int len = Math.min(size, pq.length);
            for (int i = 0; i < len; i++)
                t[i] = pq[i];
            pq = t;
        }

        public void show() {
            for (int i = 1; i <= size; i++)
                StdOut.print(pq[i] + " ");
            StdOut.println();
        }
    }

    // a class for experiment
    public static class Node implements Comparable<Node>
    {
        private int index;
        private Comparable value;

        public Node(int index, Comparable value)
        { this.index = index; this.value = value; }

        public int compareTo(Node that)
        { return this.value.compareTo(that.value); }

        public String toString()
        { return "index " + index + " value " + value; }
    }

    // test
    public static void main(String[] args)
    {
        // not stable
        StdOut.println("not stable priority queue");
        chapter2.Section4.MinPQ<Node> notStablePQ = new chapter2.Section4.MinPQ();
        notStablePQ.insert(new Node(0, 1));
        notStablePQ.insert(new Node(1, 3));
        notStablePQ.insert(new Node(2, 2));
        notStablePQ.insert(new Node(3, 4));
        notStablePQ.insert(new Node(4, 2));
        while (!notStablePQ.isEmpty())
        {
            StdOut.println(notStablePQ.delKey());
        }

        // stable
        StdOut.println("\nstable priority queue");
        MinPQ<Node> stablePQ = new Exercise24().new MinPQ();
        stablePQ.insert(new Node(0, 1));
        stablePQ.insert(new Node(1, 3));
        stablePQ.insert(new Node(2, 2));
        stablePQ.insert(new Node(3, 4));
        stablePQ.insert(new Node(4, 2));
        while (!stablePQ.isEmpty())
        {
            StdOut.println(stablePQ.delKey());
        }
    }
}
