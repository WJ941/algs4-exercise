package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;

public class Exercise4
{
    public static String[] dedup(String[] a)
    {
        int N = a.length;
        int dupCount = 0;
        for (int i = 1; i < N; i++)
        {
            int j = i;
            while (j > 0 && j < N)
            {
                int prevIndex = j-1;
                while (prevIndex > 0 && a[prevIndex] == null)
                    prevIndex--;
                int cmp = a[j].compareTo(a[prevIndex]);
                if (cmp < 0)
                {
                    exchange(a, j, prevIndex);
                    j = prevIndex;
                }
                else if (cmp == 0)
                {
                    a[j] = null;
                    dupCount++;
                    break;
                }
                else
                    break;
            }
        }
        String[] result = new String[N - dupCount];
        for (int i = 0, j = 0; i < N; i++)
            if (a[i] != null)
                result[j++] = a[i];
        return result;
    }
    public static void exchange(Object[] a, int i, int j)
    {
        Object t = a[i]; a[i] = a[j]; a[j] = t;
    }
    public static void show(String[] a)
    {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    public static void testDedup()
    {
        String[] a= {"a", "a", "a", "a", };
        show(dedup(a));
        String[] b= {"c", "b", "a", "f", "e", "c", "j", "m", "a","k"};
        show(dedup(b));
        String[] c= {"c", "c", "f", "e"};
        show(dedup(c));
    }
}
