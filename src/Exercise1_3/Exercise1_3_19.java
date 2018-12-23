package Exercise1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise1_3_19<Item> implements Iterable<Item> {
    private class Node
    {
        private Item item;
        private Node next;
    }
    public Node first;
    public int size;
    public boolean isEmpty() { return size == 0; }
    public void add(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }
    public void deleteLast()
    {

        if (first != null) // size > 0
        {
            if (first.next != null) // size >= 1
            {
                Node copy = first;
                while(copy.next.next != null)
                {
                    copy = copy.next;
                }
                copy.next = null;
            }
            else // size = 1
            {
                first = null;
            }
            size--;
        }

    }
    public void delete(int k)
    {

        if (k > 0 && k <= size)
        {

            if (k == 1)
            {
                first = first.next;
            }
            else
            {
                // find k - 1 's node; (k - 1).next = (k - 1).next.next
                Node temp = first;

                while(k > 2)
                {
                    temp = temp.next;
                    k--;
                }
                temp.next = temp.next.next;
            }

            size--;
        }
    }
    public boolean find(String key)
    {
        if(isEmpty()) return false;
        Node temp = first;
        while(temp != null)
        {
            if (temp.item.equals(key))
                return true;
            temp = temp.next;
        }
        return false;
    }
    public void removeAfter(Node node)
    {
        if (node == null) return;
        Node temp = first;
        while(temp != null)
        {
            if(temp.item.equals(node.item))
            {
                temp.next = null;
                return;
            }
            temp = temp.next;
        }
    }
    public Node createNode(Item item)
    {
        Node node = new Node();
        node.item = item;
        return node;
    }
    public void insertAfter(Node dist, Node newNode)
    {
        if (dist == null || newNode == null) return;
        Node temp = first;
        while(temp != null)
        {
            if(temp.item.equals(dist.item))
            {
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        }
    }
    public void remove(String key)
    {
        if (isEmpty() || key == null) return;
        while (first.item.equals(key))
        {
            first = first.next;
        }
        Node temp = first;
        while (temp != null)
        {
            if (temp.next != null && temp.next.item.equals(key))
            {
                temp.next = temp.next.next;
            }
            else
            {
                temp = temp.next;
            }
        }

    }

    public Iterator<Item> iterator()
    {
        return new LinkIterator();
    }
    public class LinkIterator implements Iterator<Item>
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

//       Exercise1_3_19<String> demo = new Exercise1_3_19<>();
//       demo.add("node 2");
//       demo.add("node 2");
//       demo.add("node 4");
//       demo.add("node 3");
//       demo.add("node 2");
//       demo.add("node 1");
//       demo.add("node 1");
//
//        StdOut.println("before: ");
//        for(String item : demo)
//        {
//            StdOut.println(item);
//        }
//        demo.remove("node 2");
//        StdOut.println("after: ");
//        for(String item : demo)
//        {
//            StdOut.println(item);
//        }
    }
}
