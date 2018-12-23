import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    private Node first;
    private Node last;
    private int N = 0;
    private class Node
    {
        Item item;
        Node next;
    }
    public void enqueue(Item item)
    {
        if (first == null)
        {
            first = last = new Node();
            first.item = item;
        }
        else
        {
            Node newLast = new Node();
            newLast.item = item;
            last.next = newLast;
            last = newLast;
        }
        N++;
    }
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if (first == last)
        {
            last = first;
        }
        N--;
        return item;
    }
    public int size()
    {
        return N;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public static void main(String[] args)
    {
        Queue<String> q = new Queue<>();
        while(!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if(!s.equals("-"))
            {
                q.enqueue(s);
            }
            else if(!q.isEmpty())
            {
                StdOut.println(q.dequeue() + " ");
            }
        }
        StdOut.println("( " + q.size() + " ) left on stack.");
    }
}
