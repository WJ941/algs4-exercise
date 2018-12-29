package chapter2.Section2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise23_Improvements
{
    public static double test(String alg, int T, int N)
    {
        double totalTime = 0;
        for (int i = 0; i < T; i++)
        {
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform();
            Stopwatch timer = new Stopwatch();
            if (alg.equals("improvement")) Exercise11_Improvements.sort(a);
            else if (alg.equals("merge")) Merge.sort(a);
            totalTime += timer.elapsedTime();
        }
        return totalTime;
    }
    public static void main(String[] args)
    {
        int T = 100, N = 1000;
        double improvementTime = test("improvement", T, N);
        double mergeTime = test("merge", T, N);
        StdOut.printf(" improvement/merge %.3f\n", improvementTime / mergeTime );
    }
}
