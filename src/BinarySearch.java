import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


public class BinarySearch {
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);

        StdOut.println("before:");
        for (int i = 0; i < whitelist.length; i++)
            StdOut.print(whitelist[i] + " ");
        StdOut.println();

        while (!StdIn.isEmpty())
        {
            int k = StdIn.readInt();
            int index = rank(k, whitelist);
            if (index > -1)
                // delete
                whitelist = remove(whitelist, index);
        }

        StdOut.println("after:");
        for (int i = 0; i < whitelist.length; i++)
            StdOut.print(whitelist[i] + " ");
        StdOut.println();

    }
    public static int rank(int k, int[] a)
    {
        return rank(k, a, 0, a.length - 1);
    }
    public static int rank(int k, int[] a, int lo, int hi)
    {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (k > a[mid]) return rank(k, a, mid + 1, hi);
        else if (k < a[mid]) return rank(k, a, lo, mid - 1);
        else return mid;
    }
    public static int[] remove(int[] a, int index)
    {
        int[] result = new int[a.length - 1];
        for (int i = 0; i < index; i++) {
            result[i] = a[i];
        }
        for (int i = index + 1; i < a.length; i++) {
            result[i - 1] = a[i];
        }
        return result;
    }
}
