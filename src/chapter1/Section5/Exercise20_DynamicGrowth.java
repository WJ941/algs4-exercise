package chapter1.Section5;

public class Exercise20_DynamicGrowth {
    private int[] id = new int[1];
    private int size = 0;
    public Exercise20_DynamicGrowth() {

    }
    public int find(int i)
    {
        int q = id[i];
        while (q != id[q]) q = id[q];
        return q;
    }
    public boolean connected(int p, int q)
    { return find(p) == find(q); }
    public void union(int q, int p)
    {
        int qRoot = find(q);
        int pRoot = find(p);
        if (qRoot == pRoot) return;
    }
    public int newSite()
    {
        return  0;
    }
}
