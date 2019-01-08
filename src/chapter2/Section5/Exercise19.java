package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19
{

    public static int getDistance(Comparable[] a, Comparable[] b)
    {
        int lenA = a.length;
        int lenB = b.length;
        int count = 0;
        if (lenA != lenB) return 0;
        for (int i = 0; i < lenA - 1; i++)
            for (int j = i + 1; j < lenA; j++)
                if (a[i].compareTo(a[j]) < 0 && b[i].compareTo(b[j]) > 0
                        || a[i].compareTo(a[j]) > 0 && b[i].compareTo(b[j]) < 0
                ) count++;

        return count;
    }
    public static void main(String[] args)
    {
        Integer[] a = {1, 2, 3,	4, 5, };
        Integer[] b = {3, 4, 1,	2, 5, };
        StdOut.println(getDistance(a, b));
    }
}
