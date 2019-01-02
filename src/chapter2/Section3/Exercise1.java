package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1
{
    public static void sort(Comparable[] a)
    {
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
        // print
        StdOut.print(ANSI.ANSI_RED);
        StdOut.printf("%3s%3s", "i", "j");
        for (int k = 0; k < a.length; k++)
            StdOut.printf("%3d", k);
        StdOut.println();
        StdOut.printf("%3d%3d", i, j);
        for (int k = 0; k < a.length; k++)
            StdOut.printf("%3s", a[k]);
        StdOut.println(ANSI.ANSI_RESET);

        while (true)
        {
            int prevI = i;
            while (v.compareTo(a[++i]) >= 0) if (i == hi) break;
            int prevJ = j;
            while (v.compareTo(a[--j]) <= 0) if (j == lo) break;

            // between lo and prevI
            StdOut.printf("%3d%3d", i, j);
            for (int k = lo; k <= prevI; k++)
                StdOut.printf("%3s", a[k]);
            // i move
            StdOut.print(ANSI.ANSI_RED);
            for (int k = prevI + 1; k <= i; k++)
                StdOut.printf("%3s", a[k]);
            StdOut.print(ANSI.ANSI_RESET);
            // between i and j
            for (int k = i+1; k < j; k++)
                StdOut.printf("%3s", a[k]);
            // j move
            StdOut.print(ANSI.ANSI_RED);
            for (int k = j; k < prevJ; k++)
                StdOut.printf("%3s", a[k]);
            StdOut.print(ANSI.ANSI_RESET);
            // between prevJ and hi
            for (int k = prevJ; k <= hi; k++)
                StdOut.printf("%3s", a[k]);
            StdOut.println();

            if (i >= j) break;
            Quick.exch(a, i, j);
            // print exchange
            StdOut.printf("%3d%3d", i, j);
            // between lo and i
            for (int k = lo; k < i; k++)
                StdOut.printf("%3s", a[k]);
            // i
            StdOut.printf(ANSI.ANSI_RED + "%3s" + ANSI.ANSI_RESET, a[i]);
            // between i and j
            for (int k = i+1; k < j; k++)
                StdOut.printf("%3s", a[k]);
            // j
            StdOut.printf(ANSI.ANSI_RED + "%3s" + ANSI.ANSI_RESET, a[j]);
            // between j and hi
            for (int k = j+1; k <= hi; k++)
                StdOut.printf("%3s", a[k]);
            StdOut.println();
        }
        Quick.exch(a, lo, j);
        // print last exchange
        StdOut.printf("%3d%3d", i, j);
        StdOut.printf(ANSI.ANSI_RED + "%3s" + ANSI.ANSI_RESET, a[lo]);
        // between lo and i
        for (int k = lo + 1; k < j; k++)
            StdOut.printf("%3s", a[k]);
        // i
        StdOut.printf(ANSI.ANSI_RED + "%3s" + ANSI.ANSI_RESET, a[j]);
        // between i and j
        for (int k = j+1; k <= hi; k++)
            StdOut.printf("%3s", a[k]);
        StdOut.println();
        return j;
    }
    public static void main(String[] args)
    {
        String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
//        sort(a);
        partition(a, 0, a.length - 1);
//        assert Quick.isSort(a);
        Quick.show(a);
    }
}
