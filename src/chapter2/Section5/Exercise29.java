package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise29
{
    public static class SizeComparator implements Comparator<File>
    {
        public int compare(File a, File b)
        {
            if (a.isDirectory() && b.isDirectory()) return 0;
            else if (!a.isDirectory() && b.isDirectory()) return 1;
            else if (a.isDirectory() && !b.isDirectory()) return -1;
            else
            {
                long t = a.length() - b.length();
                if (t == 0) return 0;
                else if (t < 0) return -1;
                else return 1;
            }
        }
    }
    public static class LastModificationComparator implements Comparator<File>
    {
        public int compare(File a, File b)
        {
            long t = a.lastModified() - b.lastModified();
            if (t == 0) return 0;
            else if (t < 0) return -1;
            else return 1;
        }
    }
    public static void sortFile(String filename, Comparator c)
    {
        File file = new File(filename);
        if (!file.isDirectory()) return;
        File[] files =  file.listFiles();
        Arrays.sort(files, c);
        for (int i = 0, N = files.length; i < N; i++)
            StdOut.println(files[i].getName());
    }
    public static void main(String[] args)
    {
        sortFile(args[0], new SizeComparator());
        StdOut.println(" sort  by last modification ");
        sortFile(args[0], new LastModificationComparator());
    }
}
