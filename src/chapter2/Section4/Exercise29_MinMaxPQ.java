package chapter2.Section4;

import edu.princeton.cs.algs4.In;

public class Exercise29_MinMaxPQ
{
    private class MinMaxPQ<key extends Comparable<key>>
    {
        private MinPQ<key> minPQ = new MinPQ();
        private MaxPQ<key> maxPQ = new MaxPQ();
        // logarithmic
        public void insert(key v)
        {
            minPQ.insert(v);
            maxPQ.insert(v);
        }
        // logarithmic
        public key delMax()
        {
            return null;
        }
        // logarithmic
        public key delMin()
        {
            return null;
        }
        public key min() { return minPQ.min(); }
        public key max() { return maxPQ.max(); }
    }
}
