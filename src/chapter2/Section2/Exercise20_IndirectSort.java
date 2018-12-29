package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise20_IndirectSort
{
    public static int[] indirectSort(Comparable[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        int[] perm = new int[hi+1];
        for (int i = 0; i <= hi; i++)
            perm[i] = i;
        sort(a, perm, lo, hi);
        return perm;
    }
    public static void sort(Comparable[] a, int[] perm, int lo, int hi)
    {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, perm, lo, mid);
        sort(a, perm, mid + 1, hi);
        merge(a, perm, lo, mid, hi);
    }
    public static void merge(Comparable[] a, int[] perm, int lo, int mid, int hi)
    {
        int i = lo;
        int j = mid + 1;
        int[] auxPerm = new int[perm.length];
        for (int k = lo; k <= hi ; k++)
            auxPerm[k] = perm[k];
        for (int k = lo; k <= hi ; k++)
        {
            if (i > mid) perm[k] = auxPerm[j++];
            else if (j > hi) perm[k] = auxPerm[i++];
            else if (a[auxPerm[i]].compareTo(a[auxPerm[j]]) < 0)
                perm[k] = auxPerm[i++];
            else
                perm[k] = auxPerm[j++];
        }
        for (;i <= mid; i++)
        {
            if (a[perm[i]].compareTo(a[perm[j]]) > 0)
            {
                int t = perm[i];
                perm[i] = perm[j];
                perm[j] = t;
            }
        }
    }
    public static void main(String[] args)
    {
        int N = 100;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        int[] perm = indirectSort(a);
        for (int i = 0, len = perm.length; i < len; i++)
            StdOut.print(perm[i] + " ");
        StdOut.println();

        for (int i = 0, len = perm.length; i < len-1; i++)
            if (a[perm[i]].compareTo(a[perm[i+1]]) > 0)
            {
                StdOut.println("false " + i);
            }
        StdOut.println("true");

    }
}
