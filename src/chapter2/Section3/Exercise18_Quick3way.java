package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise18_Quick3way
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt)
        {
            int cmp = a[i].compareTo(a[lo]);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, gt--, i);
            else               i++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void doublingTest()
    {
        double prevTime = 1.0;
        for (int N = 100; true; N+=N)
        {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(0.0, N);
            Stopwatch timer = new Stopwatch();
            sort(a);
            double curTime = timer.elapsedTime();
            StdOut.printf("current time / previous time %.3f\n", curTime / prevTime);
            prevTime = curTime;
        }
    }
    public static void main(String[] args)
    {
        doublingTest();
    }
}
