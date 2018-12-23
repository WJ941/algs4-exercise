package Exercise1_4;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.List;

public class Exercise1_4_22 {
    public static int binarySearch(int[] arr, int key)
    {
        int fk1 = 0;
        int fk = 1;
        while (fk < arr.length)
        {
            int oldFk = fk;
            fk = fk + fk1;
            fk1 = oldFk;
        }
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi)
        {
            int fk2 = fk - fk1;
            StdOut.println("f k-2 " + fk2);
            if (key < arr[fk2])
            {
                hi = fk2 - 1;
                fk = fk2;
                fk1 = fk1 - fk2;
            }
            else if (key > arr[fk2])
            {
                for (int i = fk2 + 1; i <= hi; i++)
                {
                    if (arr[i] == key)
                        return i;
                }
                break;
            }
            else
                return fk2;

        }
        return -1;
    }

    /**
     * return k th fibonacci number
     * @param index
     * @return
     */

    public static int fibonacci(int index)
    {
        assert index >=0 : "fibonacci index must greater than zero";
        if (index == 0) return 0;
        else if (index == 1) return 1;
        else return fibonacci(index -2) + fibonacci(index - 1);
    }

    /**
     * return index of fibonacci number that is greater than max.
     * @param max
     * @return
     */
    public static int fibonacciMaxIndex(int max)
    {
        int i = 0;
        int f = 0;
        while (f < max)
        {
            f = fibonacci(++i);
        }
        return i;
    }
    public static void main()
    {
        int[] a = StdIn.readAllInts();
        Arrays.sort(a);
        int key = 287381;

        Stopwatch s2 = new Stopwatch();
        StdOut.println(BinarySearch.indexOf(a, key));
        StdOut.println("binary " + s2.elapsedTime());

        Stopwatch s1 = new Stopwatch();
        StdOut.println(binarySearch(a, key));
        StdOut.println("fibonacci " + s1.elapsedTime());
    }
}
