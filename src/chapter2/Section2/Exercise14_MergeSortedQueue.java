package chapter2.Section2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;


public class Exercise14_MergeSortedQueue {
    public static Queue<Comparable> mergeSortedQueue(Queue<Comparable> q, Queue<Comparable> p)
    {
        Queue<Comparable> result = new Queue<>();
        Comparable prevP = null;
        Comparable prevQ = null;
        while ( (prevQ != null || q.size() > 0) && (prevP != null ||p.size() > 0))
        {
            if (prevP != null)
            {
                Comparable curQ = q.dequeue();
                if (curQ.compareTo(prevP) < 0)
                    result.enqueue(curQ);
                else
                {
                    result.enqueue(prevP);
                    prevP = null;
                    prevQ = curQ;
                }
            }
            else if (prevQ != null)
            {
                Comparable curP = p.dequeue();
                if (curP.compareTo(prevQ) < 0)
                    result.enqueue(curP);
                else
                {
                    result.enqueue(prevQ);
                    prevQ = null;
                    prevP = curP;
                }
            }
            else
            {
                Comparable curQ = q.dequeue();
                Comparable curP = p.dequeue();
                if (curP.compareTo(curQ) < 0)
                {
                    result.enqueue(curP);
                    prevQ = curQ;
                }
                else
                {
                    result.enqueue(curQ);
                    prevP = curP;
                }
            }
        }
        if (q.size() == 0)
            if (prevP != null) result.enqueue(prevP);
            while (p.size() > 0)
                result.enqueue(p.dequeue());
        if (p.size() == 0)
            if (prevQ != null) result.enqueue(prevQ);
            while (q.size() > 0)
                result.enqueue(q.dequeue());
        return result;
    }
    public static void main(String[] args)
    {
        Queue<Comparable> queue1 = new Queue<>();
        queue1.enqueue(1);
        queue1.enqueue(3);
        queue1.enqueue(5);
        queue1.enqueue(7);
        Queue<Comparable> queue2 = new Queue<>();
        queue2.enqueue(2);
        queue2.enqueue(4);
        queue2.enqueue(6);
        queue2.enqueue(8);
        Queue<Comparable> result = mergeSortedQueue(queue1, queue2);
        StdOut.println(result.toString());
    }
}
