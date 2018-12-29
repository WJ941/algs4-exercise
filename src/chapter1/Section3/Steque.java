package chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {
    private class Node
    {
        public Item item;
        public Node next;
    }
    public int size = 0;
    public boolean isEmpty() { return size == 0; }
    public Node first;
    public Node last;
    public void push(Item item)
    {
        if (isEmpty())
        {
            first = new Node();
            first.item = item;
            last = first;
        }
        else
        {
            Node newNode = new Node();
            newNode.item = item;
            newNode.next = first;
            first = newNode;
        }
        size++;
    }
    public Item pop()
    {
        if(isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        if (size == 1)
        {
            last = null;
        }
        size--;
        return item;
    }
    public void enqueue(Item item)
    {
        Node newNode = new Node();
        newNode.item = item;
        if(isEmpty())
        {
            first = last = newNode;
        }
        else
        {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Iterator<Item> iterator()
    {
        return new StequeIterator();
    }
    private class StequeIterator implements Iterator<Item>
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

    public static void main()
    {
        Steque<Integer> steque = new Steque<>();
        steque.push(2);
        steque.push(1);
        StdOut.println("pop " + steque.pop());
        StdOut.println("pop " + steque.pop());
        steque.enqueue(3);
        steque.enqueue(4);
        for (Integer i : steque)
        {
            StdOut.println("ite " + i);
        }
    }
}
