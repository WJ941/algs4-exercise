import edu.princeton.cs.algs4.StdOut;

public class SmartDate {
    private final int year;
    private final int month;
    private final int day;
    public SmartDate(int y, int m, int d)
    {
        if (y <= 0 || m <= 0 || d <= 0) throw new IllegalArgumentException("Year, month and day must be positive number");
        if (m < 1 || m > 12) throw new IllegalArgumentException("month must be between 1 and 12");
        // little month have 30 days
        int[] littleMonth = {1, 3, 5, 7, 9, 11};
        // big month have 31 days
        int[] bigMonth = {4, 6, 8,10, 12};
        for (int i = 0; i < littleMonth.length; i++)
        {
            if (littleMonth[i] == m && d > 30)
                throw new IllegalArgumentException("Month "+ m +" only have 30 days");
        }
        for (int i = 0; i < bigMonth.length; i++)
        {
            if (bigMonth[i] == m && d > 31)
                throw new IllegalArgumentException("Month "+ m +" only have 31 days");
        }
        if (m == 2)
        {
            if (isLeapYear(y) && d > 29)
                throw new IllegalArgumentException("Year " + y + " month " + m + " must only 29 days");
            if (!isLeapYear(y) && d > 28)
                throw new IllegalArgumentException("Year " + y + " month " + m + " must only 28 days");
        }
        year = y;
        month = m;
        day = d;
    }
    public int year()
    {
        return year;
    }
    public int month()
    {
        return month;
    }
    public int day()
    {
        return day;
    }
    public String toString()
    {
        return year + "/" + month + "/" + day;
    }
    public String dayOfWeek()
    {
        int y = year;
        int m;
        if (month == 1)
        {
            m = 11;
            y--;
        } else if (month == 2)
        {
            m = 12;
            y--;
        }
        else
        {
            m = month - 2;
        }
        if (m == 1 || m == 2) y--;
        int c = y / 100;
        y %= 100;
        double w = (day + (2.6 * m - 0.2) + 5 * (y % 4) + 3 * y + 5 * (c % 4)) % 7;
        String[] weeks = {null, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saterday", "Sunday"};
        return weeks[(int)w];
    }
    private boolean isLeapYear(int y)
    {
        if ( y < 0) return false;
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0 && y % 3200 != 0);
    }

    public static void main(String[] args)
    {
        SmartDate sd = new SmartDate(2008, 2, 29);
        StdOut.println("year  " + sd.year());
        StdOut.println("month " + sd.month());
        StdOut.println("day   " + sd.day());
        StdOut.println(sd);
        StdOut.println(sd.dayOfWeek());
    }
}
