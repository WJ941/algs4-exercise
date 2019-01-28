package chapter3.Section2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise6_BST_height_field
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
            private int height;
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

        public int height()
        { return height(root); }
        private int height(Node x)
        {
            if (x == null) return 0;
            return x.height;
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
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            return x;
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
            x.height = Math.max(height(x.left), height(x.right)) + 1;
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
            x.height = Math.max(height(x.left), height(x.right)) + 1;
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
            x.height = Math.max(height(x.left), height(x.right)) + 1;
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
}
