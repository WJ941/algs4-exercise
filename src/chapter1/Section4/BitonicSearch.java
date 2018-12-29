package chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

public class BitonicSearch {
    public static boolean contains(int[] a, int key)
    {
        int lo = 1;
        int hi = a.length - 2;
        int peak = 0;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (a[mid - 1] < a[mid] && a[mid] < a[mid + 1])
                lo = mid + 1;
            else if (a[mid - 1] > a[mid] && a[mid] > a[mid + 1])
                hi = mid - 1;
            else if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1])
            {
                peak = mid;
                break;
            }
            else
            {
                StdOut.println("input data error");
            }
        }
        StdOut.println("peak " + peak);

        return ascendingBinarySearch(a, key, 0, peak) > -1 || descendingBinarySearch(a, key, peak + 1, a.length - 1) > -1;
    }
    public static int ascendingBinarySearch(int[] arr, int key, int lo, int hi)
    {
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (arr[mid] < key)
                lo = mid + 1;
            else if (arr[mid] > key)
                hi = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    public static int descendingBinarySearch(int[] arr, int key, int lo, int hi)
    {
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (arr[mid] < key)
                hi = mid - 1;
            else if (arr[mid] > key)
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    public static void main()
    {
        int[] a = {1, 2, 3, 5, 6, 7, 5, 3};
        StdOut.println(contains(a, 4));
    }
}
