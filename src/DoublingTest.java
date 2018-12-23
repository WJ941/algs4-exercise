import edu.princeton.cs.algs4.*;

public class DoublingTest {
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
    public static void main()
    {
        drawLogImg();
    }
    public static void drawStandardImg()
    {
        StdDraw.setXscale(0, 8000);
        StdDraw.setYscale(0, 50);
        StdDraw.setPenRadius(0.01);
        for (int N = 100; N < 8000; N += 100)
        {
            double time = timeTrial(N);
            StdOut.printf("%9d %9.1f\n", N, time);
            StdDraw.point(N, time);
        }
    }
    public static void drawLogImg()
    {
        StdDraw.setXscale(0, 8000);
        StdDraw.setYscale(0, 10);
        StdDraw.setPenRadius(0.01);
        for (int N = 100; N < 8000; N += 100)
        {
            double time = timeTrial(N);
            StdOut.printf("%9d %9.1f\n", N, time);
            StdDraw.point(Math.log(N), Math.log(time));
        }
    }
}
