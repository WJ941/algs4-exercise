import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
public class Matrix {
    public static void main(String[] args)
    {
        StdOut.print("test function dot: ");
        double[] x1 = {1, 2, 3};
        double[] y1 = {1, 2, 3};
        StdOut.println(dot(x1, y1) == 14);

        StdOut.print("test function 2d mult: ");
        double[][] x2 = {{1, 2, 3}, {4, 5, 6}};
        double[][] y2 = {{7, 8}, {9, 10}, {11, 12}};
        double[][] result2 = {{58.0, 64.0}, {139.0, 154.0}};
        StdOut.println(equals(mult(x2, y2), result2));

        StdOut.print("test function transpose: ");
        double[][] x3 = {{1, 2, 3}, {4, 5, 6}};
        double[][] result3 = {{1, 4}, {2, 5}, {3, 6}};
        StdOut.println(equals(transpose(x3), result3));

        StdOut.print("test function mult: ");
        double[][] x4 = {{1, 2, 3}, {4, 5, 6}};
        double[] y4 = {7, 8, 9};
        double[] result4 = {50, 122};
        StdOut.println(Arrays.equals(mult(x4, y4), result4));

        StdOut.print("test function mult: ");
        double[] x5 = {7, 8, 9};
        double[][] y5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[] result5 = {102, 126, 150};
        StdOut.println(Arrays.equals(mult(x5, y5), result5));

    }
    /**
     * vector dot product
     * @param x vector x
     * @param y vector y
     * @return dot product of two vector
     * @throws IllegalArgumentException if {@code x} and {@code y} have different length
     */
    public static double dot(double[] x, double[] y)
    {
        if (x.length != y.length) throw new IllegalArgumentException("dot product arguments must have same length!");
        int sum = 0;
        for (int i = 0; i < x.length; i++)
            sum += x[i] * y[i];
        return sum;
    }

    /**
     * calculate multiple of two matrix
     * @param a matrix a
     * @param b matrix b
     * @return multiple of two matrix
     * @throws IllegalArgumentException if columns of a not equal to rows of b
     */
    public static double[][] mult(double[][] a, double[][] b)
    {
        if (a[0].length != b.length) throw new IllegalArgumentException("columns of a must equal to rows of b");
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < result[i].length; j++)
            {
                result[i][j] = dot(a[i], column(b, j));
            }
        }
        return result;
    }

    /**
     * transpose matrix
     * @param a matrix need to transpose
     * @return transposed matrix
     */
    public static double[][] transpose(double[][] a)
    {
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = column(a ,i);
        }
        return result;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static double[] mult(double[][] a, double[] b)
    {
        if (a[0].length != b.length) throw new IllegalArgumentException("colums of a must equal to length of b");
        double[][] b2 = new double[b.length][1];
        for (int i = 0; i < b.length; i++)
        {
            b2[i][0] = b[i];
        }
        double[][] result = mult(a, b2);
        return column(result, 0);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static double[] mult(double[] a, double[][] b)
    {
        if (a.length != b.length) throw new IllegalArgumentException("length of a must equal to rows of b");
        double[][] a2 = new double[1][a.length];
        a2[0] = a;
        double[][] result = mult(a2, b);
        return result[0];
    }

    private static double[] column(double[][] a, int i)
    {
        double[] result = new double[a.length];
        for (int j = 0; j < result.length; j++)
        {
            result[j] = a[j][i];
        }
        return result;
    }
    private static boolean equals(double[][] a, double[][] b)
    {
        if (a.length != b.length || a[0].length != b[0].length) return false;
        for (int i = 0; i < a.length; i++)
        {
            if (!Arrays.equals(a[i], b[i]))
                return false;
        }
        return true;
    }
    private static void print(double[][] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }
    }
    private static void print1d(double[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
