package chapter2.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise27 {
    public static void main(String[] args)
    {
        String shell = "Shell";
        String insertion = "Insertion";
        String selection = "Selection";
        int N = 128;
        int T = 100;
        double prevShellTime = 1;
        double prevInsertionTime = 1;
        double prevSelectionTime = 1;
        for (;true;N+=N)
        {
            double shellTime = SortCompare.timeRandomInput(shell, N, T);
            double insertionTime = SortCompare.timeRandomInput(insertion, N, T);
            double selectionTime = SortCompare.timeRandomInput(selection, N, T);
            StdOut.printf("For %d random double\n", N);
            StdOut.printf("  shell %.3f insertion %.3f selection %.3f \n", shellTime/prevShellTime, insertionTime/prevInsertionTime, selectionTime/prevSelectionTime);
            prevShellTime = shellTime;
            prevInsertionTime = insertionTime;
            prevSelectionTime = selectionTime;
        }
    }
}
