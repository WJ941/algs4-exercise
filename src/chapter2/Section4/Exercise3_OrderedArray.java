package chapter2.Section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise3_OrderedArray<key extends Comparable<key>>
{
    private int size = 0;
    key[] array;
    public Exercise3_OrderedArray()
    {
        array = (key[]) new Comparable[1];
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public int size()
    {
        return size;
    }
    public void insert(key v)
    {
        array[size++] = v;
        int i = size-1;
        while (i > 0 && less(i, i-1))
        {
            exch(i, --i);
        }
        if (size >= array.length / 2) resize(array.length*2);
    }
    public key delKey()
    {
        key t = array[--size];
        array[size] = null;
        if (size <= array.length / 4) resize(array.length / 2);
        return t;
    }
    public void exch(int i, int j)
    {
        key t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public void resize(int size)
    {
        key[] temp = (key[]) new Comparable[size];
        int len = Math.min(array.length, size);
        for (int i = 0; i < len; i++)
            temp[i] = array[i];
        array = temp;
    }
    public boolean less(int i, int j)
    {
        return array[i].compareTo(array[j]) < 0;
    }
    public static void test()
    {
        StdOut.println("ordered array test");
        Exercise3_OrderedArray<String> pq = new Exercise3_OrderedArray<>();
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
