package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise24_Sort_testImprovement
{
    private static Comparable[] aux;
    private static int count;
    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        count = 0;
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, hi, mid);
    }
    public static void merge(Comparable[] a, int lo, int hi, int mid)
    {
        // Exercise 2.2.8 improvement
        if (a[mid].compareTo(a[mid+1]) <= 0)
        {
            count++;
            return;
        }
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
    public static int getCount() { return count; }
    public static double averageCount(int N, int T)
    {
        double totalCount = 0;
        for (int i = 0; i < T; i++)
        {
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform();
            sort(a);
            totalCount += getCount();
        }
        return totalCount / T;
    }
    public static void main(String[] args)
    {
        int T = 10;
        for (int N = 64; true; N += N)
        {
            StdOut.printf("N %6d count %.3f estimate %.3f\n", N, averageCount(N, T), N / 3.0);
        }
    }
}
