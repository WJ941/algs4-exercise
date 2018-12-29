package chapter2.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a)
    {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        else if (alg.equals("Selection")) Selection.sort(a);
        else if (alg.equals("Shell")) Shell.sort(a);
        else if (alg.equals("Insertion-with-sentinel")) Exercise24_Insertion.sort(a);
        else if (alg.equals("Insertion-without-exchange")) Exercise25_InsertionSortWithoutExchange.sort(a);
        else if (alg.equals("Exercise29-shell")) Exercise29.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++)
        {
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }
    public static void main(String[] args)
    {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double time1 = timeRandomInput(alg1, N, T);
        double time2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random double\n", N);
        StdOut.printf("  %s is %.3f times faster than %s\n", alg1, time2 / time1, alg2);
    }
}
