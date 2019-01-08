package chapter2.Section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise3_UnorderedLinkList<key extends Comparable<key>>
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
            head = newNode;
        else
        {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public key delKey()
    {
        size--;
        key maxValue;
        Node max = head;
        Node prevOfMax = null;
        Node temp = head.next;
        Node prevOfTemp = head;
        while (temp != null)
        {
            if (temp.item.compareTo(max.item) > 0)
            {
                max = temp;
                prevOfMax = prevOfTemp;
            }
            temp = temp.next;
            prevOfTemp = prevOfTemp.next;
        }
        if (max.equals(head))
        {
            maxValue = head.item;
            head = head.next;
        }
        else
        {
            maxValue = max.item;
            prevOfMax.next = max.next;
        }
        return maxValue;
    }
    public static void test()
    {
        StdOut.println("unordered link-list test");
        Exercise3_UnorderedLinkList<String> pq = new Exercise3_UnorderedLinkList<>();
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
