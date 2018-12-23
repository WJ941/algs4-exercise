package Exercise1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_4_8 {
    public static void main()
    {
//        int[] a = StdIn.readAllInts();
        int[] a = {1, 2, 3, 4, 2, 5, 2, 2};
        int cnt = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++)
        {
            int index = BinarySearch.indexOf(a, a[i]);
            if (BinarySearch.indexOf(a, a[i]) > i)
            {
                cnt++;

            }
            StdOut.println(a[i] + " " + index);
        }
    }
}
