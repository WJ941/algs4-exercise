package chapter2.Section4;

public class Exercise15
{
    public static boolean isMinPQ(Comparable[] a)
    {
        int k = 1; int N = a.length-1;
        while (2*k <= N)
        {
            if (a[k].compareTo(a[2*k]) > 0 || (2*k < N && a[k].compareTo(a[2*k+1]) > 0))
                return false;
            k--;
        }
        return true;
    }
}
