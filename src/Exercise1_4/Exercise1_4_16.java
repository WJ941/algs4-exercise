package Exercise1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_4_16 {
    public static double closest(double[] a)
    {
        Arrays.sort(a);
        double dis = Math.abs(a[a.length - 1] - a[0]);
        for (int i = 0; i < a.length - 1; i++)
        {
            double d = Math.abs(a[i + 1] - a[i]);
            if (d < dis) dis = d;
        }
        return dis;
    }
    public static void main()
    {
        double[] a = StdIn.readAllDoubles();
        StdOut.println(closest(a));
    }
}
