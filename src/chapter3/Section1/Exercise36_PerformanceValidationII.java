package chapter3.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise36_PerformanceValidationII
{
    public static void main(String[] args)
    {
        int N = 100;
        int i = 0;
        BinarySearchST<String, Integer> st = new BinarySearchST<>(1024000);
        Stopwatch timer = new Stopwatch();
        double prevTime = 1.0;
        while (!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            if (word.length() < 8) continue;
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word)+1);
            i++;
            if (i == N)
            {
                double currentTime = timer.elapsedTime();
                StdOut.println(N + " " +  currentTime/prevTime);
                prevTime = currentTime;
                N += N;
            }
        }
        StdOut.println(st.size());
        StdOut.println(i);
    }
}
