package chapter2.Section4;

import edu.princeton.cs.algs4.StdOut;

public class MinPQ<key extends Comparable<key>>
{
    key[] pq;
    private int size = 0;
    public MinPQ()
    { pq = (key[]) new Comparable[1]; }
    public MinPQ(int max)
    {
        pq = (key[]) new Comparable[max+1];
    }
    public MinPQ(key[] a)
    {
        int N = a.length;
        size = N;
        pq = (key[]) new Comparable[N+1];
        for (int i = 0; i < N; i++)
            pq[i+1] = a[i];
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
    }
    public key min()
    {
        return pq[1];
    }
    public key delKey()
    {
        key min = pq[1];
        exch(1, size--);
        pq[size+1] = null;
        sink(1);
        if (size <= pq.length / 4) resize(pq.length / 2);
        return min;
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
        while (k > 1 && less(k, k/2))
        {
            exch(k/2, k);
            k /= 2;
        }
    }
    public void sink(int k)
    {
        while (2*k <= size)
        {
            int j = 2 * k;
            if (j < size && less(j+1, j)) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
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
    public static void main(String[] args)
    {
        Integer[] a = {7, 6, 5, 4, 3, 2, 1, };
        MinPQ<Integer> pq = new MinPQ<>(a);
        pq.show();
    }
}
