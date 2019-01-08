package chapter2.Section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1
{
    public static void main(String[] args)
    {
        MaxPQ<String> pq = new MaxPQ<>();
        pq.insert("P");
        pq.insert("R");
        pq.insert("I");
        pq.insert("O");
        StdOut.println(pq.delKey() + " Except R");
        pq.insert("R");
        StdOut.println(pq.delKey() + " Except R");
        StdOut.println(pq.delKey() + " Except P");
        pq.insert("I");
        StdOut.println(pq.delKey() + " Except O");
        pq.insert("T");
        StdOut.println(pq.delKey() + " Except T");
        pq.insert("Y");
        StdOut.println(pq.delKey() + " Except Y");
        StdOut.println(pq.delKey() + " Except I");
        StdOut.println(pq.delKey() + " Except I");
        pq.insert("Q");
        pq.insert("U");
        pq.insert("E");
        StdOut.println(pq.delKey() + " Except U");
        StdOut.println(pq.delKey() + " Except Q");
        StdOut.println(pq.delKey() + " Except E");
        pq.insert("U");
        StdOut.println(pq.delKey() + " Except U");
        pq.insert("E");
    }
}
