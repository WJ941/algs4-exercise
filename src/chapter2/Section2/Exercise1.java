package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1 {
    private static Comparable[] aux;
    public static void merge(Comparable[] a, int lo, int hi, int mid)
    {
        int i = lo; int j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
        {
            for (int m = lo; m < i; m++)
                StdOut.printf("%3s", "");
            StdOut.printf(ANSI_RED + "%3s" + ANSI_RESET, a[i]);
            for (int m = i+1; m <= mid; m++)
                StdOut.printf("%3s", a[m]);
            for (int m = mid+1; m < j; m++)
                StdOut.printf("%3s", "");
            StdOut.printf(ANSI_RED + "%3s" + ANSI_RESET, a[j]);
            for (int m = j+1; m < a.length; m++)
                StdOut.printf("%3s", a[m]);
            StdOut.println();

            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = a[j++];
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

        String[] a = {"E", "E", "G", "M", "R", "A", "C", "E", "R", "T"};
        StdOut.print(ANSI_RED);
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%3d", i);
        StdOut.println();
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%3s", a[i]);
        StdOut.printf(ANSI_RESET + "\n");

        aux = new Comparable[a.length];
        merge(a, 0, 9, 4);
    }
}
