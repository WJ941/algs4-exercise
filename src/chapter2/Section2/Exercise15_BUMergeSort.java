package chapter2.Section2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise15_BUMergeSort {
    public static void sort(Comparable[] a)
    {
        Queue<Queue> queue = new Queue<>();
        for (int i = 0; i < a.length; i++)
        {
            Queue<Comparable> item = new Queue<>();
            item.enqueue(a[i]);
            queue.enqueue(item);
        }
        while (queue.size() > 1)
        {
            Queue<Comparable> item1 = queue.dequeue();
            Queue<Comparable> item2 = queue.dequeue();
            queue.enqueue(Exercise14_MergeSortedQueue.mergeSortedQueue(item1, item2));
        }
        Queue<Comparable> result = queue.dequeue();
        int i = 0;
        for (Comparable value : result)
            a[i++] = value;
    }
    public static void main(String[] args)
    {
        int N = 100;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        sort(a);
        assert Merge.isSorted(a);
    }
}
