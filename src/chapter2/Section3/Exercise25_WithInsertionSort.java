package chapter2.Section3;

import edu.princeton.cs.algs4.*;

public class Exercise25_WithInsertionSort
{
    public static void sort(Comparable[] a, int lo, int hi, int CUTOFF)
    {
        if (hi <= lo) return;
        if (hi - lo + 1 <= CUTOFF)
        {
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = Quick.partition(a, lo, hi);
        sort(a, lo, j-1, CUTOFF);
        sort(a, j + 1, hi, CUTOFF);
    }
    public static void main(String[] args)
    {
        StdDraw.setPenRadius(0.01);
        for (int N = 1000; N <= 1000000; N *= 10)
        {
            Integer[] a = new Integer[N];

            for (int M = 0; M <= 30; M++)
            {
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform(Integer.MAX_VALUE);
                Stopwatch timer = new Stopwatch();
                sort(a, 0, a.length - 1, M);
                StdDraw.point(M / 30.0, timer.elapsedTime());
            }
        }
    }
}
