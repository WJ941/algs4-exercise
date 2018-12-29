package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise11_Improvements
{
    private static Comparable[] aux;
    public static void sort(Comparable[] a)
    {
        Comparable[] aux = a.clone();
        sort(a, aux,0, a.length - 1);
    }
    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (lo >= hi) return;
        // improvement 1
        if (hi-lo <= 15)
        {
            insertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid+1, hi);


        if (less(a[mid], a[mid+1]))
            System.arraycopy(a, lo, aux, lo, hi-lo+1);
        merge(a, aux, lo, mid, hi);
    }
    public static void merge(Comparable[] a, Comparable[] aux, int lo,  int mid, int hi)
    {
        // improvement 2
        if (less(a[mid], a[mid+1])) return;
        int i = lo; int j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
    private static void insertionSort(Comparable[] a, int lo, int hi)
    {
        for (int i = lo+1; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
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
        Integer[] a = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        sort(a);
        show(a);
        assert isSorted(a);
        show(a);
    }
}
