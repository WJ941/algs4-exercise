package chapter3.Section2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise13_BST_norecursive
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
            Node x = root;
            while (x != null)
            {
                int cmp = key.compareTo(x.key);
                if (cmp > 0) x = x.right;
                else if (cmp < 0) x = x.left;
                else return x.value;
            }
            return null;
        }

        public void put(Key key, Value value)
        {
            if (root == null)
            {
                root = new Node(key, value, 1);
                return;
            }
            Node x = root;
            Stack<Node> path = new Stack<>();
            while (x != null)
            {
                int cmp = key.compareTo(x.key);
                path.push(x);
                if (cmp > 0) x = x.right;
                else if (cmp < 0) x = x.left;
                else
                {
                    x.value = value;
                    while (!path.isEmpty())
                    {
                        Node t = path.pop();
                        t.N = size(t.left) + size(t.right) + 1;
                    }
                    return;
                }
            }

            int i = 0;
            while (!path.isEmpty())
            {
                Node t = path.pop();
                if (i == 0)
                {
                    int cmp = key.compareTo(t.key);
                    if (cmp > 0) t.right = new Node(key, value, 1);
                    else if (cmp < 0) t.left = new Node(key, value, 1);
                }
                i++;
                t.N = size(t.left) + size(t.right) + 1;
            }
        }

        public Key min()
        {
            if (root == null) return null;
            return min(root).key;
        }
        private Node min(Node x)
        {
            if (x.left == null) return x;
            else return min(x.left);
        }

        public Key max()
        {
            if (root == null) return null;
            return max(root);
        }
        private Key max(Node x)
        {
            if (x.right == null) return x.key;
            else return max(x.right);
        }

        public Key floor(Key key)
        {
            Node x = floor(root, key);
            if (x == null) return null;
            return x.key;
        }
        private Node floor(Node x, Key key)
        {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return floor(x.left, key);
            if (cmp == 0) return x;
            Node t = floor(x.right, key);
            if (t != null) return t;
            else return x;
        }

        public Key ceiling(Key key)
        {
            Node x = ceiling(root, key);
            if (x == null) return null;
            return x.key;
        }
        private Node ceiling(Node x, Key key)
        {
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp > 0) return ceiling(x.right, key);
            if (cmp == 0) return x;
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }

        public Key select(int k)
        {
            return select(root, k);
        }
        private Key select(Node x, int k)
        {
            if (x == null) return null;
            int size = size(x.left);
            if (k > size) return select(x.right, k - size - 1);
            else if (k < size) return select(x.left, k);
            else return x.key;
        }

        public int rank(Key key)
        {
            return rank(root, key);
        }
        private int rank(Node x, Key key)
        {
            if (x == null) return 0;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return rank(x.left, key);
            else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
            else return size(x.left);
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

    // test get() and put()
    public static void main(String[] args)
    {
        BST<String, Integer> st = new Exercise13_BST_norecursive().new BST<>();
        for (int i = 0; !StdIn.isEmpty(); i++)
        {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String key : st.keys())
            StdOut.println(key + " " + st.get(key));
    }
}
