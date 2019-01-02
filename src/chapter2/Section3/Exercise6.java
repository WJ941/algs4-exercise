package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise6
{
    private static int count;
    public static void sort(Comparable[] a)
    {
        count = 0;
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
//            count++;
            while (v.compareTo(a[++i]) > 0)
            {
                count++;
                if (i == hi) break;
            }
            count++;
            while (v.compareTo(a[--j]) < 0)
            {
                count++;
                if (j == lo) break;
            }
            count++;
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
    public static int getCount() { return count; }
    public static void main(String[] args)
    {
        int N = 100;
        for (; N <= 1000; N *= 10)
        {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(0.0, N);
            sort(a);
            StdOut.println("count " + getCount() + " calculate " + 2*N*Math.log(N));
        }
    }
}
