package chapter1.Section5;

import edu.princeton.cs.algs4.StdOut;
import chapter1.Section3.Exercise34_RandomBag;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise18_RandomGrid {
    public static class Connection
    {
        int p;
        int q;
        public Connection(int p, int q)
        { this.p = p; this.q = q; }
    }
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        Connection[] connections = generate(N);
        for (int i = 0, length = connections.length; i < length; i++)
            StdOut.println("connection " + connections[i].p + " " + connections[i].q);
    }
    public static Connection[] generate(int N)
    {
        Connection[] cons = new Connection[N * N];
        Exercise34_RandomBag<Connection> randomBag = new Exercise34_RandomBag();

        for (int i = 0; i < N * N; i++)
        {
            int p = StdRandom.uniform(0, N * N);
            int q = StdRandom.uniform(0, N * N);
            Connection c = new Connection(p, q);
            randomBag.add(c);
        }
        int i = 0;
        for (Connection c : randomBag)
        {
            cons[i] = c;
            i++;
        }
        return cons;
    }
}
