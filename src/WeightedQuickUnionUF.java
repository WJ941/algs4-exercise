import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    private int count;
    private int[] a;
    private int[] size;
    public WeightedQuickUnionUF(int N)
    {
        a = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i < a.length; i++)
        {
            a[i] = i;
            size[i] = 1;
        }
    }
    public int find(int q)
    {
        while (q != a[q]) q = a[q];
        return q;
    }
    public void union(int q, int p)
    {
        int qRoot = find(q);
        int pRoot = find(p);
        if (qRoot == pRoot) return;
        if (size[qRoot] > size[pRoot])
        {
            a[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        else
        {
            a[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
        printArray();
    }
    private void printArray()
    {
        for (int i = 0; i < a.length; i++)
        {
            StdOut.print("a[" + i + "] = " + a[i] + " ");
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
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
