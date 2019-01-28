package chapter3.Section2;

public class Exercise29_BinaryTreeCheck
{
    public static boolean isBinaryTree(BST<String, Integer>.Node x)
    {
        if (x == null) return true;
        int subTreeCount = 0;
        if (x.left() != null) subTreeCount += x.left().count();
        if (x.right() != null) subTreeCount += x.right().count();
        if (x.count() != subTreeCount + 1) return false;

        isBinaryTree(x.left());
        isBinaryTree(x.right());
        return true;
    }
}
