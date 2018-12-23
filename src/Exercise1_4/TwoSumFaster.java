package Exercise1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class TwoSumFaster {
    public static int twoSumFaster(int[] a)
    {
        if (a.length < 2 || a[0] > 0 || a[a.length - 1] < 0) return 0;

        int headTailSum = a[0] + a[a.length - 1];
        if (headTailSum < 0)
            return twoSumFaster(Arrays.copyOfRange(a, 1, a.length));
        else if (headTailSum > 0)
            return twoSumFaster(Arrays.copyOfRange(a, 0, a.length - 1));
        else
            return 1 + twoSumFaster(Arrays.copyOfRange(a, 1, a.length - 1));
    }
    public static void main()
    {
        threeSumTest();
    }
    public static int twoSumFaster(int[] a, int target)
    {
        if (a.length < 2) return 0;

        int cnt = 0;
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi)
        {
            int headTailSum = a[lo] + a[hi] + target;
            if (headTailSum < 0)
                lo++;
            else if (headTailSum > 0)
                hi--;
            else
            {
                cnt++;
                lo++;
                hi--;
            }
        }
        return cnt;
    }
    public static int threeSumFaster(int[] a)
    {
        if (a.length < 3) return 0;
        int cnt = 0;
        for (int i = 0; i < a.length; i++)
        {
            cnt += twoSumFaster(Arrays.copyOfRange(a, i + 1, a.length), a[i]);
        }
        return cnt;
    }
    public static int threeSum(int[] a)
    {
        if (a.length < 3) return 0;
        int cnt = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                for (int m = j + 1; m < a.length; m++)
                    if (a[i] + a[j] + a[m] == 0) cnt++;
        return cnt;
    }
    public static void threeSumTest()
    {
        int[] a = StdIn.readAllInts();
        Arrays.sort(a);
        StdOut.println("length " + a.length);
        Stopwatch faster = new Stopwatch();
        int fasterCnt = threeSumFaster(a);
        StdOut.println("N 2 time " + faster.elapsedTime());

        Stopwatch normal = new Stopwatch();
        int normalCnt = threeSum(a);
        StdOut.println("N 3 time " + normal.elapsedTime());

        StdOut.println(fasterCnt);
        StdOut.println(normalCnt);
    }
}
