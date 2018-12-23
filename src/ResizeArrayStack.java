import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizeArrayStack<Item> implements Iterable<Item>
{
    private int N = 0;
    Item[] a = (Item[]) new Object[1];

    public void push(Item item)
    {
        if (a.length == N) resize(a.length * 2);
        a[N++] = item;
    }
    public Item pop()
    {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }
    public void resize(int m)
    {
        Item[] temp = (Item[]) new Object[m];
        for (int i = 0; i < a.length; i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }
    public class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        public boolean hasNext() { return i > 0; }
        public Item next() { return a[--i]; }
        public void remove() {}
    }
    public static void main(String[] args)
    {
        ResizeArrayStack<Integer> ints = new ResizeArrayStack<>();
        ints.push(1);
        ints.push(2);
        ints.push(3);
        for (Integer i : ints)
        {
            StdOut.println(i);
        }
    }
}
