package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise23_JavaSystemSort
{
    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (lo >= hi) return;
        int p = lo-1;
        int i = lo-1;
        int j = hi+1;
        int q = hi+1;
        Comparable v = ninther(a, lo, hi);
        while (true)
        {
            while (a[++i].compareTo(v) < 0) if (i == hi) break;
            while (a[--j].compareTo(v) > 0) if (j == lo) break;
            if (i == j && a[i].compareTo(v) == 0)
                exch(a, ++p, i);
            if (i >= j) break;
            exch(a, i, j);
            if (a[i].compareTo(v) == 0) exch(a, ++p, i);
            if (a[j].compareTo(v) == 0) exch(a, --q, j);
        }
        i = j+1;
        for (int k = lo; k <= p; k++)
            exch(a, k, j--);
        for (int k = q; k <= hi; k++)
            exch(a, k, i++);
        sort(a, lo, j);
        sort(a, i, hi);
    }
    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static Comparable ninther(Comparable[] a, int lo, int hi)
    {
        if (hi - lo + 1 < 9) return a[lo];
        int segLen = (hi - lo + 1) / 3;
        int i = median(a, median(a, lo, lo+1, lo+2), median(a, lo+segLen, lo+segLen+1, lo+segLen+2), median(a, lo+2*segLen, lo+2*segLen+1, lo+2*segLen+2));
        return a[i];
    }
    public static int median(Comparable[] a, int i, int j, int k)
    {
        if (a[i].compareTo(a[j]) <= 0 && a[j].compareTo(a[k]) <= 0
            || a[k].compareTo(a[j]) <= 0 && a[j].compareTo(a[i]) <= 0
        )
            return j;
        else if (a[j].compareTo(a[i]) <= 0 && a[i].compareTo(a[k]) <= 0
            || a[k].compareTo(a[i]) <= 0 && a[i].compareTo(a[j]) <= 0
        )
            return i;
        else
            return k;
    }

    public static void main(String[] args)
    {
        int N = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, N);
        sort(a);
        Quick.show(a);
        assert Quick.isSort(a);
    }
}
