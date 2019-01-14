package chapter3.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1
{
    public static void main(String[] args)
    {
        BinarySearchST<String, Double> grades = new BinarySearchST<>(11);
        grades.put("A+", 4.33);
        grades.put("A" , 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B" , 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C" , 2.00);
        grades.put("C-", 1.67);
        grades.put("D" , 1.00);
        grades.put("F" , 0.00);

        String[] levels = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        Double[] grade = {4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00};
        int N  = 10;
        double scores = 0.0;
        double estimateScores = 0.0;
        for (int i = 0; i < N; i++)
        {
            int j = StdRandom.uniform(levels.length);
            String level = levels[j];
            scores += grades.get(level);
            estimateScores += grade[j];
            StdOut.print(level + " ");
        }
        StdOut.println();
        StdOut.printf("Average grade %.2f, expect %.2f\n", scores / N, estimateScores / N);
    }
}
