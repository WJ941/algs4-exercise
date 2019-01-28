package chapter3.Section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1
{

    /*
              E
          A       S
               Q      Y
            I       U
               O     T
             N
             AEINOQSUTY
     */
    public static void main(String[] args) {
        String[] str = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        BST<String, Integer> bst = new BST<>();
        for (int i = 0; i < str.length; i++)
            bst.put(str[i], i);
        bst.show();
        StdOut.print(bst.cmpCount);
        assert bst.cmpCount == (1+1+2+2+3+1+2+4+3+4+5) : "compare count error!";
    }
}
