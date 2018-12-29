package chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Exercise34_RandomBag<Item> implements Iterable<Item> {
    private int size = 0;
    private Item[] a = (Item[]) new Object[1];
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    public void add(Item item)
    {
        if (size == a.length)
        {
            Item[] newArr = (Item[])new Object[size * 2];
            for (int i = 0; i < a.length; i++)
                newArr[i] = a[i];
            a = newArr;
        }
        a[size] = item;
        size++;
    }
    public Iterator<Item> iterator()
    {
        return new BagIterator();
    }
    private class BagIterator implements Iterator<Item>
    {
        private int index = 0;
        private Item[] random;
        public BagIterator()
        {
            random = (Item[]) new Object[size];
            // copy data
            for (int i = 0; i < size; i++)
                random[i] = a[i];
            // shuffle data
            for (int i = 0; i < size - 1; i++)
            {
                int j = StdRandom.uniform(i, size);
                Item t = random[j];
                random[j] = random[i];
                random[i] = t;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Item next() {
            return random[index++];
        }
    }

    public static void main(String[] args)
    {
        Exercise34_RandomBag<Integer> numbers = new Exercise34_RandomBag();
        for (int i = 0; i < 100; i++)
            numbers.add(i);
        for (Integer n : numbers)
            StdOut.println(n);
    }
}
