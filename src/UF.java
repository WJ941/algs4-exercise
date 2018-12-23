import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] a;
    private int count = 0;
    private int readArrCnt = 0;
    public UF(int N)
    {
        count = N;
        a = new int[N];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = i;
        }
    }
    public void union(int p, int q)
    {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < a.length; i++)
        {
            if (pId == a[i])
            {
                a[i] = qId;
                readArrCnt += 2;
            }
        }
        count--;
    }
    public int find(int p)
    {
        readArrCnt++;
        return a[p];
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    public int count()
    {
        return count;
    }
    public static void main()
    {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }

            // print array content and read array count
            StdOut.println("Array content");
            for (int i = 0; i < uf.a.length; i++)
            {
                StdOut.print("a[" + i + "] = " + uf.a[i] + " ");
            }
            StdOut.println();
            StdOut.println("Read array count = " + uf.readArrCnt);

        }
        StdOut.println(uf.count + " components");
    }
}
