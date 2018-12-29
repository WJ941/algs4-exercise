package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise26_ArrayCreation
{
    public static void sort(Comparable[] a)
    {
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
        int i = lo; int j = mid + 1;
        Comparable[] aux = new Comparable[a.length];
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
    public static double test(String alg, int T, int N)
    {
        double totalTime = 0;
        for (int i = 0; i < T; i++)
        {
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform();
            Stopwatch timer = new Stopwatch();
            if (alg.equals("in-sort")) Merge.sort(a);
            else if (alg.equals("in-merge")) sort(a);
            totalTime += timer.elapsedTime();
        }
        return totalTime;
    }
    public static void main(String[] args)
    {
        int T = 100;
        int N = 1000;
        double inSortTime = test("in-sort", T, N);
        double inMergeTime = test("in-merge", T, N);
        StdOut.printf("in-sort/in-merge %.3f\n", inSortTime / inMergeTime);
    }
}
