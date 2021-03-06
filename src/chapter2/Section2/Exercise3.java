package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise3 {

    private static Comparable[] aux;
    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        int N = a.length;
        for (int sz = 1; sz < N; sz+=sz)
            for (int lo = 0; lo + sz < N; lo+=sz+sz)
                merge(a, lo, Math.min(lo+sz+sz-1, N-1), lo+sz-1);
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
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = a[j++];
        }

        for (int k = 0; k < lo; k++)
            StdOut.printf("%3s", a[k]);
        StdOut.printf(ANSI_RED);
        for (int k = lo; k <= hi; k++)
            StdOut.printf("%3s", a[k]);
        StdOut.printf(ANSI_RESET);
        for (int k = hi+1; k < a.length; k++)
            StdOut.printf("%3s", a[k]);
        StdOut.println();
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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args)
    {

        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N", "E",};
        StdOut.printf(ANSI_RED);
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%3d", i);
        StdOut.println();
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%3s", a[i]);
        StdOut.printf(ANSI_RESET + "\n");

        sort(a);
        assert isSorted(a);
        show(a);
    }
}
