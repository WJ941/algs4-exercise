package chapter2.Section5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise26
{
    public static void drawPolygon(Point2D[] points)
    {
        int minIndex = 0;
        int N = points.length;
        for (int i = 1; i < N; i++)
        {
            int cmpY = new Exercise25.HowFarY().compare(points[minIndex], points[i]);
            int cmpX = new Exercise25.HowFarX().compare(points[minIndex], points[i]);
            if (cmpY < 0) minIndex = i;
            if (cmpY == 0 && cmpX < 0) minIndex = i;
        }
        exchange(points, 0, minIndex);
        Point2D origin = points[0];
        Point2D[] others = new Point2D[N-1];
        for (int i = 1; i < N; i++)
            others[i-1] = points[i];
        Arrays.sort(others, new Exercise25().new HowAnglePoint(origin));

        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(origin.x(), origin.y(), others[0].x(), others[0].y());
        StdDraw.text(origin.x()+1, origin.y()+1, "p");
        int otherLen = others.length;
        for (int i = 0; i < otherLen - 1; i++)
        {
            StdDraw.line(others[i].x(), others[i].y(), others[i+1].x(), others[i+1].y());
            StdDraw.text(others[i].x()+1, others[i].y()+1, "" + (i + 1));
        }
        StdDraw.line(others[otherLen-1].x(), others[otherLen-1].y(), origin.x(), origin.y());
        StdDraw.text(others[otherLen-1].x()+1, others[otherLen-1].y()+1, ""+otherLen);
    }

    public static boolean less(Comparator c, Object v, Object w)
    { return c.compare(v, w) < 0; }

    public static void exchange(Object[] array, int i, int j)
    { Object t = array[i]; array[i] = array[j]; array[j] = t; }

    public static void main(String[] args)
    {
        int N = 10;
        int M = 100;
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++)
            points[i] = new Point2D(StdRandom.uniform(M), StdRandom.uniform(M));
        drawPolygon(points);
    }
}
