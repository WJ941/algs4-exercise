package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise15
{
    public class Email implements Comparable<Email>
    {
        private String address;
        private String domain;

        public Email(String address)
        {
            this.address = address;
            this.domain = this.address.split("@")[1];
        }

        public int compareTo(Email that)
        {
            if (this == that) return 0;
            return this.domain.compareTo(that.domain);
        }

        public String toString()
        { return this.address; }
    }
    public static void main(String[] args)
    {
        Email[] emails = new Email[3];
        emails[0] = new Exercise15().new Email("wayne@cs.princeton.edu");
        emails[1] = new Exercise15().new Email("rs@cs.princeton.edu");
        emails[2] = new Exercise15().new Email("rs@as.princeton.edu");
        Arrays.sort(emails);
        for (int i = 0, len = emails.length; i < len; i++)
            StdOut.println(emails[i]);
    }
}
