package chapter2.Section5;

import com.sun.tools.javac.util.ArrayUtils;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise14
{
    public class Domain implements Comparable<Domain>
    {
        private String name;
        public Domain(String name) { this.name = name; }

        public int compareTo(Domain that)
        {
            if (this == that) return 0;
            return reverse(this.name).compareTo(reverse(that.name));
        }

        public String reverse(String name)
        {
            String result = "";
            String[] a = name.split("\\.");
            for (int len = a.length, i = len - 1; i > 0; i--)
                result += a[i] + ".";
            result += a[0];
            return result;
        }
    }
    public static void main(String[] args)
    {
        while (!StdIn.isEmpty())
        {
            String[] names = StdIn.readAllStrings();
            Domain[] domains = new Domain[names.length];

            for (int i = 0, len = domains.length; i < len; i++)
                domains[i] = new Exercise14().new Domain(names[i]);

            Arrays.sort(domains);

            for (int i = 0, len = domains.length; i < len; i++)
                StdOut.println(domains[i].name);
        }
    }
}
