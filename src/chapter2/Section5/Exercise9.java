package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise9
{
    public class Deal implements Comparable<Deal>
    {
        private double amount;
        private Date date;
        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
        public Deal(String date, Double amount)
        {
            try
            {

                this.date = dateFormat.parse(date);
            }
            catch(ParseException e)
            {
                StdOut.println(e);
            }
            this.amount = amount;
        }
        public String toString()
        {
            String s = new String();
            s += dateFormat.format(date);
            s += amount;
            return s;
        }
        public int compareTo(Deal that)
        {
            if (this == that) return 0;
            return this.amount - that.amount > 0 ? 1 : -1;
        }
    }
    public static void main(String[] args)
    {
        StdOut.println(Double.MAX_VALUE);

        Deal d1 = new Exercise9().new Deal("1-OCT-28", 3500000.0);
        StdOut.println(d1);
    }
}
