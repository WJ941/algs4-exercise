package chapter1.Section5;

import edu.princeton.cs.algs4.StdOut;

public class Exercise21_ErdosRenyiModel {
    public static void main(String[] args)
    {
        for (int i = 2; true; i+= i)
        {
            int connections = Exercise17_ErdosRenyi.count(i);
            double expect = (0.5 * i * Math.log(i));
//            StdOut.println(i + " connections " + connections + ", excepte " + expect);
            StdOut.println(i + " " + connections / expect);
        }
    }
}
