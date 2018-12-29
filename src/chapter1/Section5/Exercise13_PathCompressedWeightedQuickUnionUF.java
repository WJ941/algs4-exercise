package chapter1.Section5;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise13_PathCompressedWeightedQuickUnionUF {
    private int count;
    private int[] id;
    private int[] size;
    public Exercise13_PathCompressedWeightedQuickUnionUF(int N)
    {
        id = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i < id.length; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }
    public int find(int q)
    {
        Stack<Integer> path = new Stack<>();
        while (q != id[q])
        {
            path.push(q);
            q = id[q];
        }
        for (int point : path)
            id[point] = q;
        return q;
    }
    public void union(int q, int p)
    {
        int qRoot = find(q);
        int pRoot = find(p);
        if (qRoot == pRoot) return;
        if (size[qRoot] > size[pRoot])
        {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else
        {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
        printArray();
    }
    private void printArray()
    {
        for (int i = 0; i < id.length; i++)
        {
            StdOut.print("id[" + i + "] = " + id[i] + " ");
        }
        StdOut.println();
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    public int count() { return count;}
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Exercise13_PathCompressedWeightedQuickUnionUF uf = new Exercise13_PathCompressedWeightedQuickUnionUF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
