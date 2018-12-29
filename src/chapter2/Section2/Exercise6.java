package chapter2.Section2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise6 {
    public static int accessCount;
    private static Comparable[] aux;
    public static void sort(Comparable[] a)
    {
        accessCount = 0;
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
    public static void sortBU(Comparable[] a)
    {
        accessCount = 0;
        aux = new Comparable[a.length];
        int N = a.length;
        for (int sz = 1; sz < N; sz += sz)
            for (int lo = 0; lo + sz < N; lo += 2*sz)
                merge(a, lo,lo + sz - 1, Math.min(lo + sz+ sz - 1, N - 1));
    }
    public static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo; int j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
            accessCount+=2;
        }
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid)
            {
                a[k] = aux[j++];
                accessCount+=2;
            }
            else if (j > hi)
            {
                a[k] = aux[i++];
                accessCount+=2;
            }
            else if (less(aux[i], aux[j]))
            {
                a[k] = aux[i++];
                accessCount+=4;
            }
            else
            {
                a[k] = aux[j++];
                accessCount+=4;
            }
        }
    }
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }
    public static int getAccessCount()
    { return accessCount; }
    public static void main(String[] args)
    {
        StdDraw.setXscale(0, 520);
        StdDraw.setYscale(0, 6*512*Math.log(512));
        StdDraw.setPenRadius(0.01);
        // top down sort
        StdDraw.setPenColor(StdDraw.CYAN);
        for (int N = 1; N <= 512; N++)
        {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            sort(a);
            assert Merge.isSorted(a);
            StdDraw.point(N, getAccessCount());
        }
        // bottom up sort
        StdDraw.setPenColor(StdDraw.GREEN);
        for (int N = 1; N <= 512; N++)
        {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            sortBU(a);
            assert Merge.isSorted(a);
            StdDraw.point(N, getAccessCount());
        }
        // upper limit
        StdDraw.setPenColor(StdDraw.RED);
        for (int N = 1; N <= 512; N++)
        {
            StdDraw.point(N, 6*N*Math.log(N)/Math.log(2));
        }
    }
}
