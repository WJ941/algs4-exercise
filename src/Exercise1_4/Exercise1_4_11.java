package Exercise1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class Exercise1_4_11 {
    public static int howMany(int[] a, int key)
    {
        int lo = 0;
        int hi = a.length - 1;
        int cnt = 0;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (a[mid] > key)
            {
                hi = mid - 1;
            }
            else if (a[mid] < key)
            {
                lo = mid + 1;
            }
            else
            {
                for ( int i = mid; a[i] == key && i >= lo; i--)
                {
                    cnt++;
                }
                for (int i = mid + 1; a[i] == key && i <= hi; i++)
                {
                    cnt++;
                }
                break;
            }
        }
        return cnt;
    }
    public static void main()
    {
//        int[] a = {1, 2, 2, 2, 3, 5};
        int[] a = StdIn.readAllInts();
        StdOut.println(a.length);
        Arrays.sort(a);

        Stopwatch timer = new Stopwatch();
        StdOut.println("how many " + howMany(a, 63665));
        StdOut.println("time " + timer.elapsedTime());

        Stopwatch timer2 = new Stopwatch();
        int cnt = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == 63665) cnt++;
        }
        StdOut.println("how many2 " + cnt);
        StdOut.println("time2 " + timer2.elapsedTime());
    }
}
