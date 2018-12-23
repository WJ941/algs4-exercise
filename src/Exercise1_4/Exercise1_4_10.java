package Exercise1_4;


import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;

public class Exercise1_4_10 {
    /**
     * BinarySearch 返回最小的index
     * @param a
     * @param key
     */
    public static int indexOf(int[] a, int key)
    {
        int lo = 0;
        int hi = a.length - 1;
        return indexOf(a, key, lo, hi);
    }
    private static int indexOf(int[] a, int key, int lo, int hi)
    {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (key < a[mid] || (mid > 0 && a[mid] == key && a[mid - 1] == key)) return indexOf(a, key, lo, mid - 1);
        else if (key == a[mid])
        {
            return mid;
        }
        else return indexOf(a, key, mid + 1, hi);
    }
    public static void main()
    {
        int[] a = {2, 2, 2, 3, 5, 5,  6};
        StdOut.println(indexOf(a, 5));
//        BinarySearch.indexOf();
    }
}
