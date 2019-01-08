package chapter2.Section5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Exercise25
{
    public static class HowFarX implements Comparator<Point2D>
    {
        public int compare(Point2D a, Point2D b)
        {
            double cmp = a.x() - b.x();
            if (cmp == 0.0) return 0;
            else if (cmp > 0.0) return 1;
            else return -1;
        }
    }
    public static class HowFarY implements Comparator<Point2D>
    {
        public int compare(Point2D a, Point2D b)
        {
            double cmp = a.y() - b.y();
            if (cmp == 0.0) return 0;
            else if (cmp > 0.0) return 1;
            else return -1;
        }
    }
    public static class HowFarOrigin implements Comparator<Point2D>
    {
        public int compare(Point2D a, Point2D b)
        {
            double disA = Math.pow(a.x(), 2) + Math.pow(a.y(), 2);
            double disB = Math.pow(b.x(), 2) + Math.pow(b.y(), 2);
            double cmp = disA - disB;
            if (cmp == 0.0) return 0;
            else if (cmp > 0.0) return 1;
            else return -1;
        }
    }
    public class HowFarPoint implements Comparator<Point2D>
    {
        private Point2D reference;
        public HowFarPoint(Point2D reference)
        {
            this.reference = reference;
        }
        public int compare(Point2D a, Point2D b)
        {
            double disA = Math.pow(a.x() - reference.x(), 2) + Math.pow(a.y() - reference.y(), 2);
            double disB = Math.pow(b.x() - reference.x(), 2) + Math.pow(b.y() - reference.y(), 2);
            double cmp = disA - disB;
            if (cmp == 0.0) return 0;
            else if (cmp > 0.0) return 1;
            else return -1;
        }
    }

    public class HowAnglePoint implements Comparator<Point2D>
    {
        private Point2D origin;
        public HowAnglePoint(Point2D origin)
        {
            this.origin = origin;
        }
        public int compare(Point2D a, Point2D b)
        {
            double angleA = getAngle(a);
            double angleB = getAngle(b);
            double cmp = angleA - angleB;
            if (cmp == 0.0) return 0;
            else if (cmp > 0.0) return 1;
            else return -1;
        }
        public double getAngle(Point2D point)
        {
            double x = point.x() - origin.x();
            double y = point.y() - origin.y();
            if (x >= 0 && y == 0) return 0;
            else if (x == 0 && y > 0) return Math.PI / 2;
            else if (x < 0 && y == 0) return Math.PI;
            else if (x == 0 && y < 0) return Math.PI * 3 / 2;
            else
            {
                double sin = y / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                double angle = Math.asin(sin);
                if (x < 0 && y > 0) angle = angle + Math.PI / 2;
                else if (x < 0 && y < 0) angle = -angle + Math.PI;
                else if (x > 0 && y < 0) angle = 2*Math.PI + angle;
                return angle;
            }
        }
    }

    public static void main(String[] args)
    {
        Point2D origin = new Point2D(1, 1);
        Point2D same = new Point2D(1, 1);
        Point2D xPlus = new Point2D(2, 1);
        Point2D xMinus = new Point2D(-3, 1);
        Point2D yPlus = new Point2D(1, 2);
        Point2D yMinus = new Point2D(1, -1);
        Point2D firstQuadrant = new Point2D(2, 2);
        Point2D secondQuadrant = new Point2D(0, 2);
        Point2D thirdQuadrant = new Point2D(0, 0);
        Point2D fourthQuadrant = new Point2D(2, 0);
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(same) + " except 0");
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(xPlus) + " except 0");
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(xMinus) + " except " + Math.PI);
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(yPlus) + " except " + Math.PI / 2);
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(yMinus) + " except " + Math.PI * 3 / 2);
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(firstQuadrant) + " except " + Math.PI / 4);
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(secondQuadrant) + " except " + Math.PI  * 3 / 4);
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(thirdQuadrant) + " except " + Math.PI  * 5 / 4);
        StdOut.println(new Exercise25().new HowAnglePoint(origin).getAngle(fourthQuadrant) + " except " + Math.PI  * 7 / 4);
    }
}
