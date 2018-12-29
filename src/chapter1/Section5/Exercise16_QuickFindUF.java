package chapter1.Section5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class Exercise16_QuickFindUF {
    private int[] id;
    private int count;
    private int unionCost = 0;
    private int connectedCost = 0;
    public Exercise16_QuickFindUF(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < id.length; i++)
        {
            id[i] = i;
        }
    }
    public void union(int p, int q)
    {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < id.length; i++)
        {
            if (pId == id[i])
            {
                id[i] = qId;
                unionCost += 2;
            }
            unionCost++;
        }
        count--;
    }
    public int find(int p)
    {
        return id[p];
    }
    public boolean connected(int p, int q)
    {
        connectedCost += 2;
        return find(p) == find(q);
    }
    public int count()
    {
        return count;
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Exercise16_QuickFindUF uf = new Exercise16_QuickFindUF(N);

        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 1300);
        StdDraw.setPenRadius(0.01);
        int i = 1;
        int connectedCostTotal = 0, unionCostTotal = 0;
        while (!StdIn.isEmpty())
        {

            uf.connectedCost = 0;
            uf.unionCost = 0;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }

            // Draw connected() function cost
            int connectedCost = uf.connectedCost;
            connectedCostTotal += connectedCost;
            // ith connection's number of array accesses
            StdDraw.setPenColor(Color.blue);
            StdDraw.point(i, connectedCost);
            // accumulate average of array accesses so far
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, connectedCostTotal / i);

            // Draw union() function cost
            int unionCost = uf.unionCost;
            unionCostTotal += unionCost;
            // ith union's number of array accesses
            StdDraw.setPenColor(Color.orange);
            StdDraw.point(i, unionCost);
            // accumulate average of array accesses so far
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, unionCostTotal / i);

            i++;
        }
        StdOut.println(uf.count + " components");
    }
}
