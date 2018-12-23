package Exercise1_3;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Exercise1_3_16 {
    public static Date[] readDates()
    {
        Queue<Date> dateQueue = new Queue<>();
        while(!StdIn.isEmpty())
        {
            Date d = new Date(StdIn.readString());
            dateQueue.enqueue(d);
        }
        Date[] dateArray = new Date[dateQueue.size()];
        for (int i = 0; i < dateArray.length; i++)
        {
            dateArray[i] = dateQueue.dequeue();
        }
        return dateArray;
    }
}
