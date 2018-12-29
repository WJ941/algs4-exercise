package chapter1.Section5;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise14_HeightedQuickUnionUF {
    private int count;
    private int[] id;
    private int[] height;
    public Exercise14_HeightedQuickUnionUF(int N)
    {
        id = new int[N];
        height = new int[N];
        count = N;
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            height[i] = 0;
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
        if (height[qRoot] > height[pRoot])
        {
            id[pRoot] = qRoot;
        }
        else if (height[qRoot] < height[pRoot])
        {
            id[qRoot] = pRoot;
        }
        else
        {
            id[qRoot] = pRoot;
            height[pRoot]++;
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
        Exercise14_HeightedQuickUnionUF uf = new Exercise14_HeightedQuickUnionUF(N);
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
