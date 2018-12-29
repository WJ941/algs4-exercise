package chapter2.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void sort(Comparable[] a)
    {
        StdOut.printf("%3s %3s ", "i", "j");
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%3d", i);
        StdOut.println();
        StdOut.printf("%3s %3s ", "", "");
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%3s", a[i]);
        StdOut.println();

        for (int i = 1; i < a.length; i++)
        {
            int j = i;
            for (; j > 0 && less(a[j], a[j-1]); j--)
            {
                exch(a, j-1, j);
            }
            StdOut.printf("%3d %3d ", i, j);
            for (int k = 0; k < j; k++)
                StdOut.printf("%3s", a[k]);
            for (int k = j; k <= i; k++)
                StdOut.printf(ANSI_RED+"%3s"+ANSI_RESET, a[k]);
            for (int k = i+1; k < a.length; k++)
                StdOut.printf("%3s", a[k]);
            StdOut.println();
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
//        String[] a = StdIn.readAllStrings();
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
//        show(a);
    }
}
