package chapter3.Section2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise14_BST_nonrecursive
{
    public class BST<Key extends Comparable<Key>, Value>
    {
        private Node root;
        public int cmpCount = 0;
        private class Node
        {
            private Key key;
            private Value value;
            private Node left, right;
            private int N;
            public Node(Key key, Value value, int N)
            { this.key = key; this.value = value; this.N = N; }
        }

        public int size()
        { return size(root); }

        private int size(Node x)
        {
            if (x == null) return 0;
            else return x.N;
        }

        public Value get(Key key)
        {
            return get(root, key);
        }
        private Value get(Node x, Key key)
        {
            if (x == null) return null;
            int cmp = x.key.compareTo(key);
            if (cmp == 0) return x.value;
            else if (cmp < 0) return get(x.right, key);
            else return get(x.left, key);
        }

        public void put(Key key, Value value)
        {
            root = put(root, key, value);
        }
        public Node put(Node x, Key key, Value value)
        {
            if (x == null) return new Node(key, value, 1);
            int cmp = x.key.compareTo(key);
            cmpCount++;
            if (cmp == 0)
                x.value = value;
            else if (cmp < 0)
                x.right = put(x.right, key, value);
            else
                x.left = put(x.left, key, value);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }
        public Key min()
        {
            if (root == null) return null;
            Node parent = null;
            Node x = root;
            while (x != null)
            {
                parent = x;
                x = x.left;
            }
            return parent.key;
        }
        private Node min(Node x)
        {
            if (x.left == null) return x;
            else return min(x.left);
        }

        public Key max()
        {
            if (root == null) return null;
            Node parent = null;
            Node x = root;
            while (x != null)
            {
                parent = x;
                x = x.right;
            }
            return parent.key;
        }

        public Key floor(Key key)
        {
            if (root == null) return null;
            Node x = root;
            Node t  = null;
            while (x != null)
            {
                int cmp = key.compareTo(x.key);
                if (cmp < 0) x = x.left;
                else if (cmp == 0) return x.key;
                else
                {
                    t = x;
                    x = x.right;
                }
            }
            if (t != null) return t.key;
            return null;
        }

        public Key ceiling(Key key)
        {
            if (root == null) return null;
            Node x = root;
            Node t = null;
            while (x != null)
            {
                int cmp = key.compareTo(x.key);
                if (cmp < 0)
                {
                    t = x;
                    x = x.left;
                }
                else if (cmp == 0) return x.key;
                else x = x.right;
            }
            if (t != null) return t.key;
            return null;
        }

        public Key select(int k)
        {
            if (root == null) return null;
            Node x = root;
            while (x != null)
            {
                int size = size(x.left);
                if (k > size)
                {
                    x = x.right;
                    k = k - size - 1;
                }
                else if (k < size) x = x.left;
                else return x.key;
            }
            return null;
        }

        public int rank(Key key)
        {
            if (root == null) return 0;
            Node x = root;
            int index = 0;
            while (x != null)
            {
                int cmp = key.compareTo(x.key);
                if (cmp < 0) x = x.left;
                else if (cmp > 0)
                {
                    index += size(x.left) + 1;
                    x = x.right;
                }
                else break;
            }
            return index;
        }

        public void deleteMin()
        {
            root = deleteMin(root);
        }
        private Node deleteMin(Node x)
        {
            if (x.left == null)
                return x.right;
            x.left = deleteMin(x.left);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void deleteMax()
        {
            root = deleteMax(root);
        }
        private Node deleteMax(Node x)
        {
            if (x.right == null) return x.left;
            x.right = deleteMax(x.right);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void delete(Key key)
        {
            root = delete(root, key);
        }
        private Node delete(Node x, Key key)
        {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = delete(x.left, key);
            else if (cmp > 0) x.right = delete(x.right, key);
            else
            {
                if (x.left == null) return x.right;
                if (x.right == null) return x.left;
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void show()
        { print(root); }
        private void print(Node x)
        {
            if (x == null) return;
            print(x.left);
            StdOut.println(x.key);
            print(x.right);
        }

        public Iterable<Key> keys()
        {
            return keys(min(), max());
        }
        public Iterable<Key> keys(Key lo, Key hi)
        {
            Queue<Key> queue = new Queue<>();
            keys(root, queue, lo, hi);
            return queue;
        }
        private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
        {
            if (x == null) return;
            int cmpLo = lo.compareTo(x.key);
            int cmpHi = hi.compareTo(x.key);
            if (cmpLo < 0) keys(x.left, queue, lo, hi);
            if (cmpLo <= 0 && cmpHi >= 0) queue.enqueue(x.key);
            if (cmpHi > 0) keys(x.right, queue, lo, hi);
        }
    }

    public static void main(String[] args)
    {
        BST<String, Integer> st = new Exercise14_BST_nonrecursive().new BST<>();
        int i = 0;
        while (!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            st.put(word, i++);
        }
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));

        assert st.min().equals("A") : "Test min() failed.";
        assert st.max().equals("X") : "Test max() failed.";

        assert st.floor("1") == null : "Test floor() 1 failed.";
        assert st.floor("A").equals("A") : "Test floor() 2 failed.";
        assert st.floor("M").equals("M") : "Test floor() 3 failed.";
        assert st.floor("N").equals("M") : "Test floor() 4 failed.";
        assert st.floor("Y").equals("X") : "Test floor() 5 failed.";

        assert st.ceiling("1").equals("A") : "Test ceiling() 1 failed.";
        assert st.ceiling("B").equals("C") : "Test ceiling() 2 failed.";
        assert st.ceiling("Y") == null : "Test ceiling() 3 failed.";

        assert st.select(0).equals("A") : "Test select() 1 failed.";
        assert st.select(3).equals("H") : "Test select() 2 failed.";
        assert st.select(10) == null : "Test select() 3 failed.";

        assert st.rank("1") == 0 : "Test rank() 1 failed.";
        assert st.rank("A") == 0 : "Test rank() 1 failed.";
        assert st.rank("H") == 3 : "Test rank() 2 failed.";
        assert st.rank("Y") == 10 : "Test rank() 3 failed.";
    }
}
