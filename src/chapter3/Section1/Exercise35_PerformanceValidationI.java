package chapter3.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise35_PerformanceValidationI
{
    public static void main(String[] args)
    {
        int N = 100;
        int i = 0;
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        Stopwatch timer = new Stopwatch();
        double prevTime = 1.0;
        while (!StdIn.isEmpty())
        {
            String word = StdIn.readString();
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
    }
}
