package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19_Inversions {
    public static int inversionCount(Comparable[] a)
    {
        int len = a.length;
        Comparable[] temp = new Comparable[len];
        for (int i = 0; i < len; i++)
            temp[i] = a[i];
        return inversionCount(a, temp, 0, len - 1);
    }
    public static int inversionCount(Comparable[] a, Comparable[] temp, int lo, int hi)
    {
        if (lo >= hi) return 0;
        int count = 0, mid = (lo + hi) / 2;

        count += inversionCount(a, temp, lo, mid);
        count += inversionCount(a, temp,mid + 1, hi);
        int c = merge(a, temp, lo, mid, hi);
        count += c;
        return count;
    }
    public static int merge(Comparable[] a, Comparable[] temp, int lo, int mid, int hi)
    {
        int count = 0, i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            temp[k] = a[k];
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = temp[j++];
            else if (j > hi) a[k] = temp[i++];
            else if (temp[i].compareTo(temp[j]) > 0)
            {
                a[k] = temp[j++];
                count += (mid-i+1);
            }
            else a[k] = temp[i++];
        }
        return count;
    }
    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static void main(String[] args)
    {
        Integer[] a = { 6, 5, 3, 2, 1};
        StdOut.println(inversionCount(a));
    }
}
