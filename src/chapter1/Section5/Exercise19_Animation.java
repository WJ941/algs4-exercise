package chapter1.Section5;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise19_Animation {
    public static void main(String[] args)
    {
        int a = StdIn.readInt();
        int N = 10;
        int padding = 1;
        int width = N - 1 + 2 * padding;
//        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0 ,width);
        StdDraw.setYscale(0 ,width);

        // draw coordinate points
        StdDraw.setPenRadius(0.02);
        for (int i = 0; i < N * N; i++)
        {
            double[] p = indexToPosition(i, N, padding);
            StdDraw.point(p[0], p[1]);
        }
        // draw connections
        StdDraw.setPenRadius(0.01);
        Exercise18_RandomGrid.Connection[] connections = Exercise18_RandomGrid.generate(N);
        Exercise16_QuickUnionUF uf = new Exercise16_QuickUnionUF(N * N);
        for (int i = 0, len = connections.length; i < len; i++)
        {
            int p = connections[i].p;
            int q = connections[i].q;
            if (!uf.connected(p, q) && (p % N == q % N || p / N == q / N))
            {
                StdOut.println("p " + p + ",q " + q);
                uf.union(p, q);
                double[] pPosition = indexToPosition(p, N, padding);
                double[] qPosition = indexToPosition(q, N, padding);
                StdDraw.line(pPosition[0], pPosition[1], qPosition[0], qPosition[1]);
            }
        }
    }

    /**
     * calculate coordinate with index, index grow from left to right and from top to bottom;
     * @param i index;
     * @param N number of points on one edge
     * @return [x, y]
     */
    public static double[] indexToPosition(int i, int N, int padding)
    {
        assert N > 0 : "size of edge must greater than 0;";
        double x = padding + i % N;
        double y = (N -1 + padding)  - i / N;
        double[] result = new double[2];
        result[0] = x;
        result[1] = y;
        return result;
    }
}
