package chapter2.Section5;

import chapter2.Section4.MinPQ;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise12
{
    public class Task implements Comparable<Task>
    {
        private String name;
        private double time;

        public String getName()
        { return this.name; }

        public double getTime()
        { return this.time; }

        public Task(String name, double time)
        { this.name = name; this.time = time; }

        public int compareTo(Task that)
        {
            if (this == that || this.time == that.time) return 0;
            return this.time - that.time > 0 ? 1 : -1;
        }
    }
    public static void main(String[] args)
    {
        int N = 20;
        Task[] array = new Task[N];
        MinPQ<Task> pq = new MinPQ<>();

        for (int i = 1; i <= N; i++)
        {
            String name = "Task " + i;
            double time = StdRandom.uniform(0.0, 10);
            Task task = new Exercise12().new Task(name, time);
            array[i-1] = task;
            pq.insert(task);
        }

        double time = 0.0;
        double totalTime = 0.0;
        for (int i = 0; i < N; i++)
        {
            time += array[i].time;
            totalTime += time;
        }
        StdOut.printf("Average time %.3f \f", totalTime);
        time = 0.0;
        totalTime = 0.0;
        for (int i = 0; i < N; i++)
        {
            time += pq.delKey().time;
            totalTime += time;
        }
        StdOut.printf("Average time %.3f \f", totalTime);
    }
}
