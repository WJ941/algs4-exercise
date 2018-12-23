package Exercise1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class CircularLinkListQueue<Item> implements Iterable<Item> {
    private class Node
    {
        public Item item;
        public Node next;
    }
    public int size;
    public boolean isEmpty() { return size == 0; }
    public Node last;
    public void enqueue(Item item)
    {
        if (last == null)
        {
            last = new Node();
            last.item = item;
            last.next = last;
        }
        else
        {
            Node newNode = new Node();
            newNode.item = item;
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    public Item dequeue()
    {
        Item item = last.next.item;
        if (size == 1)
        {
            last = null;
        }
        else if (size > 1)
        {
            last.next = last.next.next;
        }
        size--;
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new CircularLinkListIterator();
    }
    private class CircularLinkListIterator implements Iterator<Item>
    {
        private Node temp = last;
        private int count = 0;
        public boolean hasNext() { return count < size; }
        public Item next() {
            Item item = temp.next.item;
            temp = temp.next;
            count++;
            return item;
        }
    }
    public static void main()
    {
        CircularLinkListQueue<Integer> q = new CircularLinkListQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        for (Integer item : q)
        {
            StdOut.println(item);
        }
    }
}
