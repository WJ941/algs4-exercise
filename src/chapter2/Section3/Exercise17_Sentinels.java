package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise17_Sentinels
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        int indexOfMax = 0;
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[indexOfMax]) > 0) indexOfMax = i;
        exch(a, indexOfMax, a.length - 1);
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
            while (v.compareTo(a[++i]) > 0);
            while (v.compareTo(a[--j]) < 0);
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
    public static void main(String[] args)
    {
        int N = 1000, T = 100;
        double withOutSentinels = test("without-sentinels", N, T);
        double withSentinels = test("with-sentinels", N, T);
        StdOut.printf("with-sentinels / without-sentinels %.3f\n", withSentinels/withOutSentinels );
    }
    public static double test(String alg, int N, int T)
    {
        double time = 0;
        for (int i = 0; i < T; i++)
        {
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform(0.0, N);
            Stopwatch timer = new Stopwatch();
            if (alg.equals("without-sentinels")) Quick.sort(a);
            else if (alg.equals("with-sentinels")) sort(a);
            time += timer.elapsedTime();
            assert isSort(a);
        }
        return time;
    }
}
