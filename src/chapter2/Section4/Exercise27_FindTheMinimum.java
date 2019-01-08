package chapter2.Section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise27_FindTheMinimum
{
    private class MaxPQ<key extends Comparable<key>>
    {
        key[] pq;
        private int size = 0;
        private key min;
        public MaxPQ()
        { pq = (key[]) new Comparable[1]; }
        public MaxPQ(int max)
        {
            pq = (key[]) new Comparable[max+1];
        }
        public MaxPQ(key[] a)
        {
            int N = a.length;
            size = N;
            pq = (key[]) new Comparable[N+1];
            for (int i = 0; i < N; i++)
            {
                if (min == null || a[i].compareTo(min) < 0)
                    min = a[i];
                pq[i+1] = a[i];
            }
            for (int i = N/2; i >= 1; i--)
                sink(i);
        }
        public boolean isEmpty()
        {
            return size == 0;
        }
        public int size()
        {
            return size;
        }
        public void insert(key v)
        {
            if (size >= pq.length / 2) resize(pq.length * 2);
            pq[++size] = v;
            swim(size);
            // update min
            if (min == null || v.compareTo(min) < 0)
                min = v;
        }
        public key max()
        { return pq[1]; }
        public key min()
        { return min; }
        public key delKey()
        {
            key max = pq[1];
            exch(1, size--);
            pq[size+1] = null;
            sink(1);
            if (size <= pq.length / 4) resize(pq.length / 2);
            if (min.equals(max)) min = null;
            return max;
        }
        public boolean less(int i, int j)
        {
            return pq[i].compareTo(pq[j]) < 0;
        }
        public void exch(int i, int j)
        {
            key t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }
        public void swim(int k)
        {
            key temp = pq[k];
            while (k > 1 && pq[k/2].compareTo(temp) < 0)
            {
                pq[k] = pq[k/2];
                k /= 2;
            }
            pq[k] = temp;
        }
        public void sink(int k)
        {
            key temp = pq[k];
            while (2*k <= size)
            {
                int j = 2 * k;
                if (j < size && less(j, j+1)) j++;
                if (pq[j].compareTo(temp) <= 0) break;
                pq[k] = pq[j];
                k = j;
            }
            pq[k] = temp;
        }
        public void resize(int size)
        {
            key[] t = (key[]) new Comparable[size];
            int len = Math.min(size, pq.length);
            for (int i = 0; i < len; i++)
                t[i] = pq[i];
            pq = t;
        }
        public void show()
        {
            for (int i = 1; i <= size; i++)
                StdOut.print(pq[i] + " ");
            StdOut.println();
        }
    }
    public static void main(String[] args)
    {
        Integer[] a = {1,2,3,4,5,6,7 };
        Exercise27_FindTheMinimum.MaxPQ<Integer> pq = new Exercise27_FindTheMinimum().new MaxPQ<>(a);
        pq.show();
        StdOut.println(pq.min() + " Except 1");
        pq.insert(-1);
        StdOut.println(pq.min() + " Except -1");
    }
}
