package chapter1.Section5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise23_ErdosRenyi {
    public static void main(String[] args)
    {
        test(10);
    }
    public static void test(int T)
    {
        int init = 100;
        for (int N =init; N < init * Math.pow(2, T); N+=N)
        {
            Stopwatch timer1 = new Stopwatch();
            int c1 = Exercise22_ErdosRenyi.quickFindCount(N);
            double quickFindTime = timer1.elapsedTime();

            Stopwatch timer2 = new Stopwatch();
            int c2 = Exercise22_ErdosRenyi.quickUnionCount(N);
            double quickUnionTime = timer2.elapsedTime();
            StdOut.printf("N %8d quick-find/quick-union %.3f\n", N, quickFindTime / quickUnionTime);
        }

    }
}
