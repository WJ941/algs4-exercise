package Exercise1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class DoubleNode
    {
        public DoubleNode prev;
        public Item item;
        public DoubleNode next;
    }
    private int size;
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public DoubleNode first;
    public DoubleNode last;
    public void pushLeft(Item item)
    {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        if (isEmpty())
        {
            first = last = newNode;
        }
        else
        {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }
    public Item popLeft()
    {
        if(isEmpty()) return null;

        Item item = first.item;
        first = first.next;
        if (size > 1)
        {
            first.prev = null;
        }
        else
        {
            last = null;
        }
        size--;
        return item;
    }
    public void pushRight(Item item)
    {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        if (isEmpty())
        {
            first = last = newNode;
        }
        else
        {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }
    public Item popRight()
    {
        if (isEmpty()) return null;
        Item item = last.item;
        last = last.prev;
        if (size > 1)
        {

            last.next = null;
        }
        else
        {
            first = null;
        }
        size--;
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item>
    {
        private DoubleNode current = first;
        public boolean hasNext() { return current != null; }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main()
    {
        Deque<Integer> deque = new Deque<>();
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        StdOut.print("3 2 1 = ");
        for (Integer i : deque)
        {
            StdOut.print(i + " ");
        }
        StdOut.println();
        StdOut.println(deque.popLeft() + " = 3");
        StdOut.println(deque.popLeft() + " = 2");
        StdOut.println(deque.popLeft() + " = 1");
        StdOut.println(deque.popLeft() + " = null");

        StdOut.println(deque.size() + " = 0");

        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);
        deque.pushRight(4);
        StdOut.print("1 2 3 4 = ");
        for (Integer i : deque)
        {
            StdOut.print(i + " ");
        }
        StdOut.println();

        StdOut.println(deque.popRight() + " = 4");
        StdOut.println(deque.popRight() + " = 3");
        StdOut.println(deque.popRight() + " = 3");
        StdOut.println(deque.popRight() + " = 1");
        StdOut.println(deque.popRight() + " = null");

        StdOut.println(deque.size() + " = 0");
    }
}
