package chapter1.Section5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class Exercise16_QuickUnionUF {
    private int count;
    private int[] id;
    private int findCost = 0;
    public Exercise16_QuickUnionUF(int N)
    {
        id = new int[N];
        count = N;
        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }
    public int find(int q)
    {
        while (q != id[q])
        {
            findCost++;
            q = id[q];
        }
        return q;
    }
    public void union(int q, int p)
    {
        int qRoot = find(q);
        int pRoot = find(p);
        if (qRoot == pRoot) return;
        id[qRoot] = pRoot;
        count--;
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    public int count() { return count;}
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Exercise16_QuickUnionUF uf = new Exercise16_QuickUnionUF(N);
        int i = 0;
        int findCostTotal = 0;
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.01);
        while (!StdIn.isEmpty())
        {
            uf.findCost = 0;
            i++;

            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q))
            {
                findCostTotal += uf.findCost;
                StdDraw.setPenColor(Color.DARK_GRAY);
                StdDraw.point(i, uf.findCost);
                StdDraw.setPenColor(Color.RED);
                StdDraw.point(i, findCostTotal / i);
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);

            findCostTotal += uf.findCost;
            StdDraw.setPenColor(Color.DARK_GRAY);
            StdDraw.point(i, uf.findCost);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i, findCostTotal / i);

        }

        StdOut.println(uf.count() + " components");
        StdOut.println(i);
    }
}
