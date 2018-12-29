package chapter1.Section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args){
        int size = Integer.parseInt(args[0]);
        int deadNum = Integer.parseInt(args[1]);

        Queue<Integer> people = new Queue<>();
        for (int i = 0; i < size; i++)
        {
            people.enqueue(i);
        }
        int count = 1;
        while (!people.isEmpty())
        {
            Integer p = people.dequeue();
            if (count == deadNum)
            {
                StdOut.println(p);
                count = 1;
            }
            else
            {
                people.enqueue(p);
                count++;
            }
        }
    }
}
