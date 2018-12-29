package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise9
{
    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1, aux);
    }
    public static void sort(Comparable[] a, int lo, int hi, Comparable[] aux)
    {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, aux);
        sort(a, mid+1, hi, aux);
        merge(a, lo, hi, mid, aux);
    }
    public static void merge(Comparable[] a, int lo, int hi, int mid, Comparable[] aux)
    {
        int i = lo; int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a)
    {
        if (a.length == 1) return true;
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
