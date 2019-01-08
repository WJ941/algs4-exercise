package chapter2.Section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise16
{

    public static int getIndex(char character)
    {
        char[] order = {
                'R', 'W', 'Q', 'O', 'J', 'M',
                'V', 'A', 'H', 'B', 'S',
                'G', 'Z', 'X', 'N', 'T',
                'C', 'I', 'E', 'K', 'U',
                'P', 'D', 'Y', 'F', 'L',
        };
        int index = -1;
        for (int i = 0, len = order.length; i < len; i++)
            if ( Character.toUpperCase(character) == order[i])
            {
                index = i;
                break;
            }
        return index;
    }
    public class Candidate implements Comparable<Candidate>
    {
        private String name;
        public Candidate(String name)
        { this.name = name; }

        public int compareTo(Candidate that)
        {
            if (this == that ) return 0;
            int len = Math.min(this.name.length(), that.name.length());
            for (int i = 0; i < len; i++)
            {
                int indexOfThis = getIndex(this.name.charAt(i));
                int indexOfThat = getIndex(that.name.charAt(i));
                if (indexOfThis < indexOfThat) return -1;
                else if (indexOfThis > indexOfThat) return 1;
            }
            return this.name.length() - that.name.length();
        }
    }
    public static void main(String[] args)
    {

        while (!StdIn.isEmpty())
        {
            String[] names = StdIn.readAllStrings();
            int N = names.length;
            Candidate[] candidates = new Candidate[N];
            for (int i = 0; i < N; i++)
                candidates[i] = new Exercise16().new Candidate(names[i]);
            Arrays.sort(candidates);

            for (int i = 0; i < N; i++)
                StdOut.println(candidates[i].name);
        }
    }
}
