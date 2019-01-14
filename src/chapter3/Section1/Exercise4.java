package chapter3.Section1;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise4
{
    public class Time implements Comparable<Time>
    {
        private int hour;
        private int minute;
        private int second;
        public Time(int hour, int minute, int second)
        {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        public Time(String str)
        {
            String[] args = str.split(":");
            this.hour = Integer.parseInt(args[0]);
            this.minute = Integer.parseInt(args[1]);
            this.second = Integer.parseInt(args[2]);
        }

        public int compareTo(Time that)
        {
            if (this == that) return 0;
            if (this.hour > that.hour) return 1;
            if (this.hour < that.hour) return -1;
            if (this.minute > that.minute) return 1;
            if (this.minute < that.minute) return -1;
            if (this.second > that.second) return 1;
            if (this.second < that.second) return -1;
            return 0;
        }

        public String toString()
        {
            return "" + hour + ":" + minute + ":" + second;
        }
    }

    public static void main(String[] args)
    {
//        BinarySearchST<Time, String> st = new BinarySearchST<>(50);
        Exercise3.OrderedSequentialST<Time, String> st = new Exercise3.OrderedSequentialST<>();
        while (!StdIn.isEmpty())
        {
            Time t = new Exercise4().new Time(StdIn.readString());
            String city = StdIn.readString();
            st.put(t,city);
        }
        StdOut.println(st.min() + " expect 09:00:00");
        StdOut.println(st.get(new Exercise4().new Time("09:00:13")) + " expect Huston");
        StdOut.println(st.floor(new Exercise4().new Time("09:05:00")) + " expect 09:03:13");
        StdOut.println(st.select(7) + " expect 09:10:25");
        Iterable<Time> times = st.keys(new Exercise4().new Time("09:15:00"), new Exercise4().new Time("09:25:00"));
        for (Time t : times)
            StdOut.print(t + " ");
        StdOut.println();
        StdOut.println("expect 09:19:32 09:19:46 09:21:05 09:22:43 09:22:54");

        StdOut.println(st.ceiling(new Exercise4().new Time("09:30:00")) + " expect 09:35:21");
        StdOut.println(st.max() + " expect 09:37:44");

        StdOut.println(st.rank(new Exercise4().new Time("09:10:25")) + " expect 7");
    }

}
