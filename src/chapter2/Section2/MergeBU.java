package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;

public class MergeBU {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int sz = 1; sz < N; sz += sz)
            for (int lo = 0; lo + sz < N; lo += sz)
                merge(a, lo, Math.min(lo + sz+ sz - 1, N - 1), lo + sz - 1);
    }
    public static void merge(Comparable[] a, int lo, int hi, int mid)
    {
        int i = lo; int j = mid + 1;
        Comparable[] aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = a[i++];
            else a[k] = a[j++];
        }
    }
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args)
    {
        Integer[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
