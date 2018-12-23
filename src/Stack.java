import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private class Node {
        private Item item;
        private Node next;
    }
    private int N = 0;
    private Node first;
    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Item peek()
    {
        return first.item;
    }
    public int size()
    {
        return N;
    }
    public boolean isEmpty()
    {
        return first == null;
    }

    public Iterator<Item> iterator()
    {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static Stack<String> copy(Stack<String> stack)
    {
        Stack<String> temp = new Stack<>();
        Stack<String> result = new Stack<>();
        for(String s : stack)
        {
            temp.push(s);
        }
        for(String s : temp)
        {
            result.push(s);
        }
        return result;
    }
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<>();
        while(!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if(!s.equals("-"))
            {
                stack.push(s);
            }
            else if(!stack.isEmpty())
            {
                StdOut.println(stack.pop() + " ");
            }
        }
        StdOut.println("( " + stack.size() + " ) left on stack.");
    }
}
