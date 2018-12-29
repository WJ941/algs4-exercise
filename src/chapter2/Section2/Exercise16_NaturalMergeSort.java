package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise16_NaturalMergeSort
{
    public static void sort(Comparable[] a)
    {
        int start = 0; int end;
        Comparable[] result = new Comparable[0];
        for (int i = 0; i < a.length; i++)
        {
            if (i == a.length - 1 || a[i].compareTo(a[i+1]) > 0)
            {
                end = i;
                Comparable[] temp = new Comparable[end - start + 1];
                for (int j = 0; j <= end-start; j++)
                    temp[j] = a[j+start];
                result = merge(result, temp);
                start = i + 1;
            }
        }
        for (int i = 0; i < a.length; i++)
            a[i] = result[i];
    }
    public static Comparable[] merge(Comparable[] a, Comparable[] b)
    {
        if (a.length == 0) return b;
        if (b.length == 0) return a;
        Comparable[] result = new Comparable[a.length + b.length];
        int i = 0;
        int aIndex = 0;
        int bIndex = 0;
        for (; i < result.length && aIndex < a.length && bIndex < b.length; i++)
        {
            if (a[aIndex].compareTo(b[bIndex]) < 0)
                result[i] = a[aIndex++];
            else
                result[i] = b[bIndex++];
        }
        for (int j = aIndex; j < a.length; j++)
        {
            result[i++] = a[j];
        }
        for (int j = bIndex; j < b.length; j++)
        {
            result[i++] = b[j];
        }
        return result;
    }
    public static void testMerge()
    {
        Integer[] a = {1, 2, 5, 12};
        Integer[] b = {3, 4, 5};
        Comparable[] c = merge(a, b);
        StdOut.println("len " + c.length);
        for (int i = 0; i < c.length; i++)
            StdOut.print(c[i] + " ");
    }
    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static void testSort()
    {
        int N = 100;
//        Double[] a = new Double[100];
//        for (int i = 0; i < N; i++)
//            a[i] = StdRandom.uniform();
        Integer[] a= {4, 3, 2, 1, -1,};
        sort(a);
        assert Merge.isSorted(a);
        show(a);
    }
    public static void main(String[] args)
    {
        testSort();
    }
}
