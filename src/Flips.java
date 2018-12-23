import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Flips {
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Counter header = new Counter("headr");
        Counter tail = new Counter("tail");
        for (int i = 0; i < N; i++)
        {
            if (StdRandom.bernoulli(0.5))
                header.increment();
            else
                tail.increment();
        }
        StdOut.println(header);
        StdOut.println(tail);
        double d = Math.abs(header.tally() - tail.tally());
        StdOut.printf("delta: %.6f\n", d / N);
    }
}
