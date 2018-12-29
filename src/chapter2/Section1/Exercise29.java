package chapter2.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise29
{
    private static int[] increments = {1, 5, 9, 41, 109, 209, 505, 929,
            2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609 };
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        int hIndex = 0;
        while (increments[hIndex] < N/3) hIndex++;
        while (hIndex >= 0 && increments[hIndex] >= 1)
        {
            int h = increments[hIndex];
            for (int i = h; i < N; i++)
                for (int j = h; j >= h && less(a[j], a[j-h]); j-=h)
                    exch(a, j, j-h);
            hIndex--;
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
        String alg1 = "Exercise29-shell";
        String alg2 = "Shell";
        int N = 1000;
        int T = 100;
        double time1 = SortCompare.timeRandomInput(alg1, N, T);
        double time2 = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random double\n", N);
        StdOut.printf("  %s is %.3f times faster than %s\n", alg1, time2 / time1, alg2);
    }
}
