package chapter3.Section1;

import edu.princeton.cs.algs4.Queue;

public class Exercise2
{
    public class ArrayST<Key, Value>
    {
        private Key[] keys;
        private Value[] values;
        private int N;

        public ArrayST(int capacity)
        {
            keys = (Key[]) new Object[capacity];
            values = (Value[]) new Object[capacity];
        }

        public void put(Key key, Value value)
        {
            if (value == null) delete(key);
            for (int i = 0; i < N; i++)
                if (keys[i].equals(key))
                {
                    values[i] = value;
                    return;
                }
            keys[N] = key;
            values[N] = value;
            N++;
        }
        public Value get(Key key)
        {
            for (int i = 0; i < N; i++)
                if (keys[i].equals(key))
                    return values[i];
            return null;
        }

        public void delete(Key key)
        {
            int index = -1;
            for (int i = 0; i < N; i++)
                if (keys[i].equals(key))
                {
                    index = i;
                    break;
                }
            if (index == -1) return;
            for (int i = index; i < N-1; i++)
            {
                keys[i] = keys[i+1];
                values[i] = values[i+1];
            }
        }

        public boolean contains(Key key)
        {
            return get(key) != null;
        }

        public boolean isEmpty()
        { return size() == 0; }

        public int size()
        { return N; }

        public Iterable<Key> keys()
        {
            Queue<Key> q = new Queue<>();
            for (int i = 0; i < N; i++)
                q.enqueue(keys[i]);
            return q;
        }
    }
}
