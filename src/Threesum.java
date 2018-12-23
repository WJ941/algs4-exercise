import edu.princeton.cs.algs4.StdOut;

public class Threesum {
    public static double count(int[] a)
    {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = i + 1; j < N; j++)
            {
                for (int k = j + 1; k < N; k++)
                {
//                    if ( (double)(a[i] + a[j]) == (double)a[k])
                    double sum = (double) a[i] + (double) a[j];
                    StdOut.println("a[i] + a[j]=" + sum);
                    if ((double)a[i] + (double) a[j] == a[k])
                    {
                        cnt++;
                        StdOut.println("a[i]=" + a[i]);
                        StdOut.println("a[j]=" + a[j]);
                        StdOut.println("a[k]=" + a[k]);

                    }
                }
            }
        }
        return cnt;
    }
}
