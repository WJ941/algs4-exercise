package Exercise1_3;

import edu.princeton.cs.algs4.Stack;

public class StackQueue<Item> {
    private Stack<Item> stack1 = new Stack<>();
    private Stack<Item> stack2;
    public void enqueue(Item item)
    {
        stack1.push(item);
    }
    public Item dequeue()
    {
        Item result;
        stack2 = new Stack<>();
        for (Item item : stack1)
        {
            stack2.push(item);
        }
        result = stack2.pop();
        stack1 = new Stack<>();
        for (Item item : stack2)
        {
            stack1.push(item);
        }
        return result;
    }
}
