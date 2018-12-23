import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private int count;
    private int[] a;
    public QuickUnionUF(int N)
    {
        a = new int[N];
        count = N;
        for (int i = 0; i < a.length; i++)
            a[i] = i;
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
        a[qRoot] = pRoot;
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
        QuickUnionUF uf = new QuickUnionUF(N);
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
