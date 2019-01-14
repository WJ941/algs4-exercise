package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value>
{
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() { return N; }

    public boolean isEmpty() { return N == 0; }

    public Value get(Key key)
    {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return values[i];
        else
            return null;
    }

    public void put(Key key, Value value)
    {
        Key max = max();
        if (max != null && key.compareTo(max) > 0)
        {
            keys[N] = key;
            values[N] = value;
            N++;
            return;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
        { values[i] = value; return; }

        for (int j = N; j > i; j--)
        { keys[j] = keys[j-1]; values[j] = values[j-1];}

        keys[i] = key;
        values[i] = value;
        N++;
    }
    public int rank(Key key)
    {
        int lo = 0; int hi = N - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            int cmp = keys[mid].compareTo(key);
            if (cmp < 0) lo = mid + 1;
            else if (cmp > 0) hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    public Key min()
    { return keys[0]; }
    public Key max()
    {
        if (isEmpty()) return null;
        return keys[N-1];
    }
    public Key select(int k)
    {
        if (k < 0 || k >= N) return null;
        return keys[k];
    }

    public Key ceiling(Key key)
    {
        if (isEmpty()) return null;
        if (key.compareTo(max()) > 0) return null;
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key)
    {
        if (isEmpty()) return null;
        if (key.compareTo(min()) < 0) return null;
        else if (key.compareTo(max()) >= 0) return max();
        else
        {
            int i = rank(key);
            if (keys[i].compareTo(key) == 0) return key;
            else return keys[i - 1];
        }
    }

    public void delete(Key key)
    {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
        {
            for (int j = i; j < N-1; j++)
            { keys[j] = keys[j+1]; values[j] = values[j+1]; }
            N--;
        }
    }

    public void deleteMin()
    {
        if (isEmpty()) return;
        keys[0] = null;
        values[0] = null;
        for (int i = 0; i < N-1; i++)
        {
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        N--;
    }

    public void deleteMax()
    {
        if (isEmpty()) return;
        keys[N-1] = null;
        values[N-1] = null;
        N--;
    }

    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }
    public Iterable<Key> keys()
    {
        if (isEmpty()) return new Queue<>();
        return keys(keys[0], keys[N-1]);
    }

    public boolean contains(Key key)
    {
        int i = rank(key);
        return i < N && keys[i].compareTo(key) == 0;
    }
}
