package Exercise1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise1_4_12 {
    public static int count(int[] a, int[] b)
    {
        if (a.length == 0 || b.length == 0) return 0;
        else if (a[a.length - 1] < b[0] || a[0] > b[b.length - 1]) return 0;
        else if (a[0] < b[0]) return count(Arrays.copyOfRange(a, 1 , a.length), b);
        else if (a[0] > b[0]) return count(a, Arrays.copyOfRange(b, 1 , b.length));
        else return 1 + count(Arrays.copyOfRange(a, 1 , a.length), Arrays.copyOfRange(b, 1 , b.length));
    }
    public static void main()
    {
        int[] a = {1, 2, 3, 5, 6, 9};
        int[] b = {1, 2, 3, 5, 6, 9};
        StdOut.println("same num " + count(a, b));

        int[] a2 = {1, 2, 3, 5, 6, 9};
        int[] b2 = {10, 12, 13, 15, 16, 19};
        StdOut.println("same num " + count(a2, b2));

        int[] a3 = {1, 2, 3, 5, 6, 9};
        int[] b3 = {-110, -100, -83, -66, -56, -19};
        StdOut.println("same num " + count(a3, b3));

        int[] a4 = {};
        int[] b4 = {-110, -100, -83, -66, -56, -19};
        StdOut.println("same num " + count(a4, b4));

        int[] a5 = {1, 2, 5, 12, 22, 55, 77, 99};
        int[] b5 = {1, 5, 22, 44, 55, 66, 77, 88, 99, 100};
        StdOut.println("same num " + count(a5, b5));
    }
}
