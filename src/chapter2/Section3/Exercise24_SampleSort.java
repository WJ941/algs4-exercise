package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise24_SampleSort
{

    public static void sort(Comparable[] a)
    {
        int k = 3;
        int sampleLen = (int)Math.pow(2, k) - 1;
        int lo = 0; int hi = a.length - 1;
        int sampleHi = lo+sampleLen-1;
        Quick.sort(a, lo, sampleHi);
        int medianIndex = (lo + sampleHi)/2;
        Quick.exch(a, medianIndex, sampleHi);
        int j = Quick.partition(a, sampleHi, hi);
        int m = j-1;
        for (int i = medianIndex; i < sampleHi; i++)
            Quick.exch(a, i, m--);
        Quick.exch(a, m+1, j);
        j = m+1;
        Quick.sort(a, lo, j-1);
        Quick.sort(a, j+1, hi);
    }
    public static void main(String[] args)
    {
        Integer[] a = {1, 9, 3, 2, 8, 4, 2, 7, 5, 11, 23, 12, 7, 88, };
        sort(a);
        Quick.show(a);
    }
}
