package chapter1.Section5;

import edu.princeton.cs.algs4.*;

public class Exercise22_ErdosRenyi {
    public static void main(String[] args)
    {

        int T = 10;
        testQuickFind(T);
        testQuickUnion(T);
        testWeightedQuickUnion(T);
    }
    public static void testQuickFind(int T)
    {
        double prevTime = 1;
        int init = 100;
        for (int N =init; N < init * Math.pow(2, T); N+=N)
        {
            Stopwatch timer = new Stopwatch();
            int c = quickFindCount(N);
            double curTime = timer.elapsedTime();
            StdOut.printf("N %5d connections %9d %.3f\n", N, c, curTime / prevTime);
            prevTime = curTime;
        }
    }
    public static void testQuickUnion(int T)
    {
        double prevTime = 1;
        int init = 100;
        for (int N =init; N < init * Math.pow(2, T); N+=N)
        {
            Stopwatch timer = new Stopwatch();
            int c = quickUnionCount(N);
            double curTime = timer.elapsedTime();
            StdOut.printf("N %5d connections %9d %.3f\n", N, c, curTime / prevTime);
            prevTime = curTime;
        }
    }
    public static void testWeightedQuickUnion(int T)
    {
        double prevTime = 1;
        int init = 100;
        for (int N =init; N < init * Math.pow(2, T); N+=N)
        {
            Stopwatch timer = new Stopwatch();
            int c = weightedQuickUnioncount(N);
            double curTime = timer.elapsedTime();
            StdOut.printf("N %5d connections %9d %.3f\n", N, c, curTime / prevTime);
            prevTime = curTime;
        }
    }
    public static int quickFindCount(int N)
    {
        QuickFindUF uf = new QuickFindUF(N);
        int connectionCount = 0;
        while (uf.count() > 1)
        {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
            }
            connectionCount++;
        }
        return connectionCount;
    }
    public static int quickUnionCount(int N)
    {
        QuickUnionUF uf = new QuickUnionUF(N);
        int connectionCount = 0;
        while (uf.count() > 1)
        {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
            }
            connectionCount++;
        }
        return connectionCount;
    }
    public static int weightedQuickUnioncount(int N)
    {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int connectionCount = 0;
        while (uf.count() > 1)
        {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
            }
            connectionCount++;
        }
        return connectionCount;
    }
}
