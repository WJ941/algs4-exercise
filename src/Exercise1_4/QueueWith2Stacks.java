package Exercise1_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class QueueWith2Stacks<Item> {
    private final Stack<Item> enqStack;
    private final Stack<Item> deqStack;
    public QueueWith2Stacks()
    {
        enqStack = new Stack<>();
        deqStack = new Stack<>();
    }
    public void enqueue(Item item)
    {
        enqStack.push(item);
    }
    public Item dequeue()
    {
        if (deqStack.isEmpty())
            moveEnqStackToDeqStack();
        return deqStack.pop();
    }
    private void moveEnqStackToDeqStack()
    {
        while (!enqStack.isEmpty())
        {
            deqStack.push(enqStack.pop());
        }
    }
    public static void main()
    {
        QueueWith2Stacks<Integer> q = new QueueWith2Stacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
    }
}
