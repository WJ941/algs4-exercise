import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class VisualCounter {
    private int value;
    private final int operatMax;
    private int operateCount;
    private final double valueAbsMax;
    public VisualCounter(int N, int max)
    {
        operatMax = N;
        valueAbsMax = max;
    }
    public void decreament()
    {
        if (operateCount < operatMax && Math.abs(value) < valueAbsMax) {
            operateCount++;
            value--;
            double x = Math.abs(value) / valueAbsMax;
            double y = (double) operateCount / operatMax;
            StdDraw.text(x, y, value+"");
            StdOut.println("decreametn");
        }
    }
    public void increament()
    {
        if (operateCount < operatMax && Math.abs(value) < valueAbsMax) {
            operateCount++;
            value++;
            double x = Math.abs(value) / valueAbsMax;
            double y = (double) operateCount / operatMax;
            StdDraw.text(x, y, value+"");
            StdOut.println("increametn");
        }
    }
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        VisualCounter vc = new VisualCounter(N, max);
        vc.increament();
        vc.increament();
        vc.decreament();
    }
}
