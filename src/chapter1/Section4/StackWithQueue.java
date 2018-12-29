package chapter1.Section4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class StackWithQueue<Item> {
    private Queue<Item> queue;
    public StackWithQueue()
    {
        queue = new Queue<>();
    }
    public void push(Item item)
    {
        queue.enqueue(item);
    }
    public Item pop()
    {
        Item item;
        Queue<Item> temp = new Queue<>();
        while (queue.size() > 1)
        {
            temp.enqueue(queue.dequeue());
        }
        item = queue.dequeue();
        queue = temp;
        return item;
    }
    public static void main()
    {
        StackWithQueue<Integer> stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());
        StdOut.println(stack.pop());

    }
}
