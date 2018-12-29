package chapter2.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise25_InsertionSortWithoutExchange
{
    public static void sort(Comparable[] array)
    {
        if (array.length < 2) return;
        for (int i = 1; i < array.length; i++)
        {
            Comparable a = array[i];
            int j = i;
            for (; j > 0 && a.compareTo(array[j-1]) < 0; j--)
                array[j] = array[j-1];
            array[j] = a;
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
        String alg1 = "Insertion";
        String alg2 = "Insertion-without-exchange";
        int N = 1000;
        int T = 100;
        double time1 = SortCompare.timeRandomInput(alg1, N, T);
        double time2 = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random double\n", N);
        StdOut.printf("  %s is %.3f times faster than %s\n", alg1, time2 / time1, alg2);
    }
}
