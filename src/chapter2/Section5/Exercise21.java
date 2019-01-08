package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Vector;

import java.util.Arrays;

public class Exercise21
{
    public class Vector implements Comparable<Vector>
    {
        private int d;
        private Integer[] data;

        public Vector(int d)
        {
            this.d = d;
            data = new Integer[d];
        }

        public Vector(Integer[] a)
        {
            d = a.length;
            data = new Integer[d];
            for (int i = 0; i < d; i++)
                data[i] = a[i];
        }

        public int compareTo(Vector that)
        {
            if (this == that) return 0;
            int len = Math.min(this.d, that.d);
            for (int i = 0; i < len; i++)
            {
                int cmp = this.data[i].compareTo(that.data[i]);
                if (cmp < 0) return -1;
                else if (cmp > 0) return 1;
            }
            return this.d - that.d;
        }
        public String toString()
        {
            String result = "";
            for (int i = 0; i < d; i++)
                result += (data[i] + " ");
            return result;
        }
    }
    public static void main(String[] args)
    {
        int N = 10;
        Vector[] vectors = new Vector[N];
        for (int i = 0; i < N; i++)
        {
            int vectorDimension = StdRandom.uniform(N);
            Integer[] data = new Integer[vectorDimension];
            for (int j = 0; j < vectorDimension; j++)
                data[j] = StdRandom.uniform(vectorDimension);
            vectors[i] = new Exercise21().new Vector(data);
        }
        Arrays.sort(vectors);
        for (int i = 0; i < N; i++)
            StdOut.println(vectors[i]);
    }
}
