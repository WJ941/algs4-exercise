import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSum;
import edu.princeton.cs.algs4.StdOut;

public class DoubleRatio {
    public static double timeTrial(int N)
    {
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
        {
            a[i] = StdRandom.uniform(-N, N);
        }
        StopWatch timer = new StopWatch();
        ThreeSum.count(a);
        return timer.elapseTime();
    }
    public static void main(String[] args)
    {
        double prev = timeTrial(50);
        for (int N = 100; true; N += N)
        {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f", N , time);
            StdOut.printf("%5.1f\n", N , time/prev);
            prev = time;
        }
    }
}
