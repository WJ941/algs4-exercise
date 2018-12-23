import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PathCompressQuickUnionUF {
    private int[] id;
    private int count = 0;
    private int readArrCnt = 0;
    public PathCompressQuickUnionUF(int N)
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
        id[pId] = qId;
        count--;
//        printIds();
    }
    public int find(int p)
    {
        StdOut.println("find " + p);
        printIds();
        readArrCnt++;
        Stack<Integer> path = new Stack<>();
        while (p != id[p])
        {
            path.push(p);
            p = id[p];
        }
        for (int point : path)
            id[point] = p;
        return p;
    }
    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }
    public int count()
    {
        return count;
    }
    private void printIds()
    {
        StdOut.println("Id content");
        for (int i = 0; i < id.length; i++)
        {
            StdOut.print("a[" + i + "] = " + id[i] + " ");
        }
        StdOut.println();
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        PathCompressQuickUnionUF uf = new PathCompressQuickUnionUF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                StdOut.println(p + " " + q);
                uf.union(p, q);
            }

            // print array content and read array count
//            StdOut.println("Read array count = " + uf.readArrCnt);

        }
        StdOut.println(uf.count + " components");
    }
}
