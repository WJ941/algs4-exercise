package chapter2.Section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise5
{
    public static void main(String[] args)
    {
        MaxPQ<String> pq = new MaxPQ<>();
        pq.insert("E");
        pq.insert("A");
        pq.insert("S");
        pq.insert("Y");
        pq.insert("Q");
        pq.insert("U");
        pq.insert("E");
        pq.insert("S");
        pq.insert("T");
        pq.insert("I");
        pq.insert("O");
        pq.insert("N");
        pq.show();
        StdOut.println("Y T U S Q N E A S I O E");
    }
}
