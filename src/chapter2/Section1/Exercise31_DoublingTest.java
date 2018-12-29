package chapter2.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise31_DoublingTest {
    public static void test(String alg)
    {
        int N = 100;
        double prevTime = 1;
        for (;true;N+=N)
        {
            Double[] a = new Double[N];
            for (int j = 0; j < N; j++)
                a[j] = StdRandom.uniform();
            double time = SortCompare.time(alg, a);
            StdOut.printf("%d estimate time: %.3f actual time: %.3f cur/prev: %.3f\n", N, time, time, time/prevTime);
            prevTime = time;
        }
    }
    public static void main(String[] args)
    {
        String shell = "Selection";
        test(shell);
    }
}
