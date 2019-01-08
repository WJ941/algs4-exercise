package chapter2.Section5;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;

public class Exercise28
{
    public static void sortFile(String filename)
    {
        File file = new File(filename);
        if (!file.isDirectory()) return;
        String[] files =  file.list();
        Arrays.sort(files);
        for (int i = 0, N = files.length; i < N; i++)
            StdOut.println(files[i]);
    }
    public static void main(String[] args)
    {
        sortFile(args[0]);
    }
}
