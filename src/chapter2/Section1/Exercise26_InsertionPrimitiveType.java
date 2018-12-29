package chapter2.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise26_InsertionPrimitiveType
{
    public static void sort(int[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j-1, j);
        }
    }
    private static boolean less(int v, int w)
    { return v - w < 0; }

    private static void exch(int[] a, int i, int j)
    { int t = a[i]; a[i] = a[j]; a[j] = t; }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static boolean isSorted(int[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args)
    {
        String alg1 = "Insertion";
        int N = 1000;
        int T = 100;
        double time1 = SortCompare.timeRandomInput(alg1, N, T);

        double time2 = 0;
        int[] a = new int[N];
        for (int i = 0; i < T; i++)
        {
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform(-N, N);
            Stopwatch timer = new Stopwatch();
            sort(a);
            time2 += timer.elapsedTime();
        }
        StdOut.printf("For %d random double\n", N);
        StdOut.printf("  %s is %.3f times faster than %s\n", alg1, time2 / time1, "primitive type");
    }
}
