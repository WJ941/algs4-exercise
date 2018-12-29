package chapter2.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise28_EqualKeys
{
    public static void main(String[] args)
    {
        int N = 10000;
        int T = 100;
        Integer[] a = new Integer[N];

        double selectionTimeTotal = 0;
        for (int i = 0; i < T; i++)
        {
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform(0, 2);
            Stopwatch selection = new Stopwatch();
            Selection.sort(a);
            selectionTimeTotal += selection.elapsedTime();
        }

        double insertionTimeTotal = 0;
        for (int i = 0; i < T; i++)
        {
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform(0, 2);
            Stopwatch insertion = new Stopwatch();
            Insertion.sort(a);
            insertionTimeTotal += insertion.elapsedTime();
        }
        StdOut.printf("For %d random double\n", N);
        StdOut.printf("  selection time / insertion time %.3f\n", selectionTimeTotal / insertionTimeTotal);
    }
}
