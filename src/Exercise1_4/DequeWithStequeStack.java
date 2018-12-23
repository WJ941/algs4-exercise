package Exercise1_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DequeWithStequeStack<Item> {
    private final StequeWith2Stacks<Item> steque;
    private final Stack<Item> stack;
    public DequeWithStequeStack()
    {
        steque = new StequeWith2Stacks<>();
        stack = new Stack<>();
    }
    private void moveStequeToStack()
    {
        while (!steque.isEmpty())
            stack.push(steque.pop());
    }
    private void moveStackToSteque()
    {
        while (!stack.isEmpty())
            steque.push(stack.pop());
    }
    public Item popRight()
    {
        if (stack.isEmpty())
            moveStequeToStack();
        return stack.pop();
    }
    public void pushRight(Item item)
    {
        stack.push(item);
    }
    public Item popLeft()
    {
        if (steque.isEmpty())
            moveStackToSteque();
        return steque.pop();
    }
    public void pushLeft(Item item)
    {
        steque.push(item);
    }
    public boolean isEmpty()
    {
        return steque.isEmpty() && stack.isEmpty();
    }
    public static void main()
    {
        DequeWithStequeStack<Integer> deque = new DequeWithStequeStack<>();
        deque.pushLeft(0);
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushRight(11);
        deque.pushRight(12);
        deque.pushRight(13);
        while (!deque.isEmpty())
            StdOut.println(deque.popRight());
    }
}
