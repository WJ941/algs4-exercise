package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise12_BinarySearchST
{

    public static void mergeSort(Comparable[] array)
    {
        Comparable[] aux = new Comparable[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    public static void mergeSort(Comparable[] array, Comparable[] aux, int lo, int hi)
    {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        mergeSort(array, aux, lo, mid);
        mergeSort(array, aux, mid+1, hi);
        merge(array, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = array[k];
        int i = lo; int j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) array[k] = aux[j++];
            else if (j > hi) array[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) <= 0) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }


    public class Item<Key extends Comparable<Key>, Value> implements Comparable<Item<Key, Value>>
    {
        private Key key;
        private Value value;

        public Item(Key key, Value value)
        { this.key = key; this.value = value; }

        public int compareTo(Item<Key, Value> that)
        {
            if (this == that) return 0;
            else return this.key.compareTo(that.key);
        }
    }

    public  class BinarySearchST<Key extends Comparable<Key>, Value>
    {
        private Item<Key, Value>[] items;
        private int N;
        public BinarySearchST(Item[] items)
        {
            N = items.length;
            this.items = new Item[items.length];
            for (int i = 0; i < items.length; i++)
                this.items[i] = items[i];
            mergeSort(this.items);
        }

        public int size() { return N; }
        public boolean isEmpty() { return size() == 0; }

        public Value get(Key key)
        {
            if (isEmpty()) return null;
            int i = rank(key);
            if (i < N && items[i].key.compareTo(key) == 0)
                return items[i].value;
            else
                return null;
        }

        public void put(Key key, Value value)
        {
            if (N >= this.items.length / 2) resize(this.items.length * 2);
            for (int i = 0; i < N; i++)
            {
                if (items[i].key.compareTo(key) == 0)
                {
                    items[i].value = value;
                    return;
                }
            }
            items[N++] = new Item<>(key, value);
        }
        public int rank(Key key)
        {
            int lo = 0; int hi = N - 1;
            while (lo <= hi)
            {
                int mid = (lo + hi) / 2;
                int cmp = items[mid].key.compareTo(key);
                if (cmp < 0) lo = mid + 1;
                else if (cmp > 0) hi = mid - 1;
                else return mid;
            }
            return lo;
        }

        public Key min()
        { return items[0].key; }

        public Key max()
        { return items[N-1].key; }

        public Key select(int k)
        { return items[k].key; }

        public Key ceiling(Key key)
        {
            int i = rank(key);
            return items[i].key;
        }

        public Key floor(Key key)
        {
            int i = rank(key);
            if (i == 0) return null;
            else return items[i-1].key;
        }

        public void delete(Key key)
        {
            if (N <= this.items.length / 4) resize(this.items.length / 2);
            int i = rank(key);
            if (i < N && items[i].key.compareTo(key) == 0)
            {
                for (int j = i; j < N-1; j++)
                { items[j] = items[j+1]; }
            }
            N--;
        }


        public Iterable<Key> keys(Key lo, Key hi)
        {
            Queue<Key> q = new Queue<>();
            for (int i = rank(lo); i < rank(hi); i++)
                q.enqueue(items[i].key);
            if (contains(hi))
                q.enqueue(items[rank(hi)].key);
            return q;
        }

        public Iterable<Key> keys()
        { return keys(items[0].key, items[N-1].key);}

        public boolean contains(Key key)
        {
            int i = rank(key);
            return i < N && items[i].key.compareTo(key) == 0;
        }

        public void resize(int len)
        {
            Item[] items = new Item[len];
            for (int i = 0; i < this.items.length; i++)
                items[i] = this.items[i];
            this.items = items;
        }
    }

    public static void main(String[] args)
    {
        String[] keys = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N", };
        int N = keys.length;
        Item<String, Integer>[] items = new Item[N];
        for (int i = 0; i < N; i++)
            items[i] = new Exercise12_BinarySearchST().new Item<>(keys[i], i);
        BinarySearchST<String, Integer> st = new Exercise12_BinarySearchST().new BinarySearchST<>(items);
        StdOut.println(st.get("S"));
    }
}
