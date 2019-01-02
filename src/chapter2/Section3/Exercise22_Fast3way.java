package chapter2.Section3;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise22_Fast3way
{
    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (lo >= hi) return;
        int p = lo;
        int i = lo;
        int j = hi+1;
        int q = hi+1;
        Comparable v = a[lo];
        while (true)
        {
            while (a[++i].compareTo(v) < 0) if (i == hi) break;
            while (a[--j].compareTo(v) > 0) if (j == lo) break;
            if (i == j && a[i].compareTo(a[lo]) == 0)
                exch(a, ++p, i);
            if (i >= j) break;
            exch(a, i, j);
            if (a[i].compareTo(a[lo]) == 0) exch(a, ++p, i);
            if (a[j].compareTo(a[lo]) == 0) exch(a, --q, j);
        }
        i = j+1;
        for (int k = lo; k <= p; k++)
            exch(a, k, j--);
        for (int k = q; k <= hi; k++)
            exch(a, k, i++);
        sort(a, lo, j);
        sort(a, i, hi);
    }
    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args)
    {
        int N = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, N);
        sort(a);
        assert Quick.isSort(a);
    }
}
