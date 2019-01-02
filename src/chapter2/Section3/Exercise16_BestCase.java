package chapter2.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise16_BestCase
{
    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);
    }
    public static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        int lenLeft = Math.max(0, j-1-lo+1);
        int lenRight = Math.max(0, hi - (j+1) + 1);
        if (Math.abs(lenLeft - lenRight) >1)
        {
            show(a);
            StdOut.println(" lo " + a[lo] + " j " + a[j] + " hi " + a[hi]);
        }
        assert Math.abs(lenLeft - lenRight) <= 1;
        sort(a, lo, j-1);
        sort(a, j + 1, hi);
    }
    public static int partition(Comparable[] a, int lo, int hi)
    {
        Comparable v = a[lo];
        int i = lo, j = hi + 1;
        while (true)
        {
            while (v.compareTo(a[++i]) >= 0) if (i == hi) break;
            while (v.compareTo(a[--j]) <= 0) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static Integer[] generate(int N)
    {
        return generate(1, N, false);
    }
    public static Integer[] generate(int lo, int hi, boolean isLeft)
    {
        Integer[] a;
        if (lo == hi)
        {
            a = new Integer[1];
            a[0] = lo;
        }
        else if (lo > hi)
        {
            a = new Integer[0];
        }
        else
        {
            int mid = (lo + hi) / 2;
            Integer[] midArr = {mid};
            Integer[] left = generate(lo, mid - 1, true);
            Integer[] right = generate(mid + 1, hi, false);
            if (isLeft)
            {
                a = concat(left, right);
                a = concat(a, midArr);
            }
            else
            {
                a = concat(midArr, left);
                a = concat(a, right);
            }

        }
        return a;
    }
    public static Integer[] concat(Integer[] a, Integer[] b)
    {
        Integer[] result = new Integer[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            result[i] = a[i];
        for (int i = 0; i < b.length; i++)
            result[a.length + i] = b[i];
        return result;
    }
    public static void show(int[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static void main(String[] args)
    {
        int N = 10;
        Integer[] a = generate(N);
        show(a);
        sort(a);
    }

}
