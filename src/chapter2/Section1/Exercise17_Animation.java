package chapter2.Section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise17_Animation {
    public static void drawSelectionSort(Comparable[] a)
    {
        int max = 0;
        for (int i = 0; i < a.length; i++)
            if (less(a[max], a[i])) max = i;
        initCanvas(a.length);

        for (int i = 0; i < a.length; i++)
        {
            StdDraw.clear();
                // draw elements before ith
            for (int k = 0; k < i; k++)
                drawRect(k, (double)a[k]/(double)a[max], false);
            // draw ith element
            drawRect(i, (double)a[i]/(double)a[max], true);
            int min = i;
            for (int j = i + 1; j < a.length; j++)
            {
                if (less(a[j], a[min])) min = j;
                // draw elements after ith
                drawRect(j, (double)a[j]/(double)a[max], true);
            }
            exch(a, i, min);

            // sleep
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void drawInsertionSort(Comparable[] a)
    {
        int max = 0;
        for (int i = 0; i < a.length; i++)
            if (less(a[max], a[i])) max = i;

        initCanvas(a.length);

        for (int i = 1; i < a.length; i++)
        {
            int j = i;
            for (; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j-1, j);

            StdDraw.clear();
            // draw elements from 0 to j not bold
            for (int k = 0; k < j; k++)
                drawRect(k, (double)a[k]/(double)a[max], false);
            // draw elements from j to i+1 bold
            for (int k = j; k < i+1; k++)
                drawRect(k, (double)a[k]/(double)a[max], true);
            // draw elements from i+1 to a.length not bold
            for (int k = i+1; k < a.length; k++)
                drawRect(k, (double)a[k]/(double)a[max], false);
            // sleep
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
        Double[] a = new Double[20];
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(0, (double)a.length);
        drawInsertionSort(a);
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
    }
    public static void initCanvas(int N)
    {
        StdDraw.setXscale(0, 2*N + 1);
    }
    public static void drawRect(int index, double height, boolean isBold)
    {
        if (isBold)
            StdDraw.setPenColor(StdDraw.BLACK);
        else
            StdDraw.setPenColor(StdDraw.GRAY);
        if (height == 0.0) height = 0.1;
        StdDraw.filledRectangle(2*index + 1, 0, 0.5, height / 2);
    }
}
