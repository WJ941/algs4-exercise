package chapter2.Section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise33
{
    private class IndexMinPQ<Key extends Comparable<Key>>
    {
        private int N;
        private int[] pq;
        private int[] qp;
        private Key[] keys;
        public IndexMinPQ(int maxN)
        {
            keys = (Key[]) new Comparable[maxN + 1];
            pq = new int[maxN + 1];
            qp = new int[maxN + 1];
            for (int i = 0; i <= maxN; i++) qp[i] = -1;
        }

        public boolean isEmpty()
        { return N == 0; }

        public boolean contains(int k)
        { return qp[k] != -1; }

        public void insert(int k, Key key)
        {
            N++;
            qp[k] = N;
            pq[N] = k;
            keys[k] = key;
            swim(N);
        }

        public Key min()
        { return keys[pq[1]]; }

        public int delMin()
        {
            int indexOfMin = pq[1];
            exch(1, N--);
            sink(1);
            keys[pq[N+1]] = null;
            qp[pq[N+1]] = -1;
            return indexOfMin;
        }
        public void swim(int k)
        {
            while (k > 1 && less(k, k/2))
            {
                exch(k/2, k);
                k /= 2;
            }
        }
        public void sink(int k)
        {
            while (2*k <= N)
            {
                int j = 2 * k;
                if (j < N && less(j+1, j)) j++;
                if (!less(j, k)) break;
                exch(k, j);
                k = j;
            }
        }
        public void exch(int i, int j)
        {
            int a = pq[i];
            pq[i] = pq[j];
            pq[j] = a;

            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }
        public boolean less(int i, int j)
        {
            return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
        }
        public void show()
        {
            for (int i = 1; i <= N; i++)
                StdOut.print( "pq[" + i +"] = " + pq[i] + ",  ");
            StdOut.println();
        }
    }
    public static void merge(In[] streams)
    {
        int N = streams.length;
        IndexMinPQ<String> pq = new Exercise33().new IndexMinPQ<String>(N);

        for (int i = 0; i < N; i++)
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        pq.show();
        while (!pq.isEmpty())
        {
            StdOut.println(pq.min());
            int i = pq.delMin();

            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
    }
    public static void main(String[] args)
    {
        int N = args.length;
        In[] streams = new In[N];
        for (int i = 0; i < N; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
}
