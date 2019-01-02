package chapter2.Section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise20_NonrecursiveQuickSort
{
    private static class Range
    {
        public int lo;
        public int hi;
        public Range(int lo, int hi)
        { this.lo = lo; this.hi = hi; }
    }
    public static void sort(Comparable[] a)
    {
        Stack<Range> stack = new Stack<>();
        stack.push(new Range(0, a.length - 1));
        while (!stack.isEmpty())
        {
            Stack<Range> temp = new Stack<>();
            while (!stack.isEmpty())
            {
                Range range = stack.pop();
                int j = Quick.partition(a, range.lo, range.hi);
                if (j-1 > range.lo)
                    temp.push(new Range(range.lo, j-1));
                if (range.hi > j+1)
                    temp.push(new Range(j+1, range.hi));
            }
            stack = temp;
        }
    }
    public static void main(String[] args)
    {
        int N = 1000; int T = 100;
        double nonrecursive = test("nonrecursive", N, T);
        double defaultSort = test("default", N, T);
        StdOut.printf("nonrecursive / default %.3f\n", nonrecursive/ defaultSort );
    }
    public static double test(String alg, int N, int T)
    {
        double time = 0.0;
        for (int j = 0; j < T; j++)
        {
            Integer[] a = new Integer[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(0, N);
            Stopwatch timer = new Stopwatch();
            if (alg.equals("nonrecursive")) sort(a);
            else if (alg.equals("default")) Quick.sort(a);
            time += timer.elapsedTime();
            assert Quick.isSort(a);
        }
        return time;
    }
}
