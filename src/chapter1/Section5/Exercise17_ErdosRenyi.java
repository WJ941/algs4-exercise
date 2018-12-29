package chapter1.Section5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Exercise17_ErdosRenyi {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        count(N);
    }
    public static int count(int N)
    {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        int connectionCount = 0;
        while (uf.count() > 1)
        {
            int p = StdRandom.uniform(0, N);
            int q = StdRandom.uniform(0, N);
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
            }
            connectionCount++;
        }
        return connectionCount;
    }
}
