package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;

public class Exercise27
{
    public static Integer[] indirectSort(Comparable[] array)
    {
        int N = array.length;
        Integer[] index = new Integer[N];

        for (int i = 0; i < N; i++)
            index[i] = i;

        for (int i = 1; i < N; i++)
            for (int j = i; j > 0 && less(array[index[j]], array[index[j-1]]); j--)
                exchange(index, j, j-1);

        return index;
    }

    public static boolean less(Comparable a, Comparable b)
    { return a.compareTo(b) < 0; }

    public static void exchange(Object[] array, int i, int j)
    { Object t = array[i]; array[i] = array[j]; array[j] = t; }

    public static boolean isSort(Comparable[] array, Integer[] index)
    {
        int N = array.length;
        if (index.length != N) return false;
        for (int i = 0; i < N-1; i++)
            if (array[index[i]].compareTo(array[index[i+1]]) > 0) return false;
        return true;
    }
    public static void show(Object[] array)
    {
        int N = array.length;
        for (int i = 0; i < N; i++)
            StdOut.print(array[i] + " ");
        StdOut.println();
    }
    public static void main(String[] args)
    {
        int N = 10;
        double M = 10.0;
        Double[] array = new Double[10];
        for (int i = 0; i < N; i++)
            array[i] = StdRandom.uniform(0, M);
        show(array);
        Integer[] index = indirectSort(array);
        show(index);
        StdOut.println("is sort " + isSort(array, index));
    }
}
