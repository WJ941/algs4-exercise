package chapter2.Section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise3_OrderedLinkList<key extends Comparable<key>>
{
    private class Node
    {
        public key item;
        public Node next;
    }
    private Node head;
    private int size = 0;
    public void insert(key value)
    {
        Node newNode = new Node();
        newNode.item = value;
        if (head == null)
        {
            head = newNode;
            return;
        }
        if (head.next == null && head.item.compareTo(value) < 0)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.item.compareTo(value) > 0)
        {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    public key delKey()
    {
        key max = head.item;
        head = head.next;
        return max;
    }
    public static void test()
    {
        StdOut.println("ordered link-list test");
        Exercise3_OrderedLinkList<String> pq = new Exercise3_OrderedLinkList<>();
        pq.insert("P");
        pq.insert("R");
        pq.insert("I");
        pq.insert("O");
        StdOut.println(pq.delKey() + " Except R");
        pq.insert("R");
        StdOut.println(pq.delKey() + " Except R");
        StdOut.println(pq.delKey() + " Except P");
        pq.insert("I");
        StdOut.println(pq.delKey() + " Except O");
        pq.insert("T");
        StdOut.println(pq.delKey() + " Except T");
        pq.insert("Y");
        StdOut.println(pq.delKey() + " Except Y");
        StdOut.println(pq.delKey() + " Except I");
        StdOut.println(pq.delKey() + " Except I");
        pq.insert("Q");
        pq.insert("U");
        pq.insert("E");
        StdOut.println(pq.delKey() + " Except U");
        StdOut.println(pq.delKey() + " Except Q");
        StdOut.println(pq.delKey() + " Except E");
        pq.insert("U");
        StdOut.println(pq.delKey() + " Except U");
        pq.insert("E");
    }
    public static void main(String[] args)
    {
        test();
    }
}
