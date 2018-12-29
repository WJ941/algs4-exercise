package chapter2.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void sort(Comparable[] a)
    {
        StdOut.printf("%3s %3s ", "i", "min");
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%3d", i);
        StdOut.println();
        StdOut.printf("%3s %3s ", "", "");
        for (int j = 0; j < a.length; j++)
            StdOut.printf("%3s", a[j]);
        StdOut.println();
        for (int i = 0; i < a.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);

            StdOut.printf("%3d %3d ", i, min);
            for (int j = 0; j < i; j++)
                StdOut.printf("%3s", a[j]);
            for (int j = i; j < a.length; j++)
                StdOut.printf(ANSI_RED + "%3s" + ANSI_RESET, a[j]);
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
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(a);
        assert isSorted(a);
    }
}
