package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j + 1, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi)
    {
        Comparable v = a[lo];
        int i = lo, j = hi + 1;
        while (true)
        {
            while (v.compareTo(a[++i]) > 0) if (i == hi) break;
            while (v.compareTo(a[--j]) < 0) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static boolean isSort(Comparable[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i].compareTo(a[i+1]) > 0) return false;
        return true;
    }
}
