package chapter1.Section4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class StequeWith2Stacks<Item> {
    private final Stack<Item> headStack;
    private final Stack<Item> tailStack;
    private void moveTailStackToHeadStack()
    {
        while (!tailStack.isEmpty())
        {
            headStack.push(tailStack.pop());
        }
    }
    public StequeWith2Stacks()
    {
        headStack = new Stack<>();
        tailStack = new Stack<>();
    }
    public void push(Item item)
    {
        headStack.push(item);
    }
    public Item pop()
    {
        if (headStack.isEmpty())
            moveTailStackToHeadStack();
        return headStack.pop();
    }
    public void enqueue(Item item)
    {
        tailStack.push(item);
    }
    public boolean isEmpty()
    {
        return headStack.isEmpty() && tailStack.isEmpty();
    }
    public static void main()
    {
        StequeWith2Stacks<Integer> steque = new StequeWith2Stacks();
        steque.push(0);
        steque.push(1);
        steque.push(2);
        steque.push(3);
        steque.push(4);
        steque.enqueue(11);
        steque.enqueue(12);
        steque.enqueue(13);
        while (!steque.isEmpty())
        {
            StdOut.println(steque.pop());
        }
    }
}
