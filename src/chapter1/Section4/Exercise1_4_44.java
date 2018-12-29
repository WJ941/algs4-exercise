package chapter1.Section4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1_4_44 {
    public static void main(String[] args)
    {
        int n = 10000000;
        StdDraw.setXscale(0, n * 2);
        StdDraw.setYscale(0, 5);
        StdDraw.setPenRadius(0.01);
        for (int i = 0;i < 1000000; i++)
        {
            double ratio = test(n);
            StdOut.printf("~sqrt(pi*n/2) %6d %.3f\n ", n - i, ratio);
            StdDraw.point(n, ratio);
        }
    }
    public static double test(int n)
    {
//        int n = Integer.parseInt(args[0]);
        boolean[] a = new boolean[n];
        int cnt = 0;
        int index = StdRandom.uniform(0, n);
        while (!a[index])
        {
            a[index] = true;
            index = StdRandom.uniform(0, n);
            cnt++;
        }
        return cnt / Math.sqrt(Math.PI * n / 2);
    }
}
