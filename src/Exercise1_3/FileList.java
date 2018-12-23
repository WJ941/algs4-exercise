package Exercise1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class FileList {
    public static void main(String[] args)
    {
        String dirName = args[0];
        File f1 = new File(dirName);
        if (f1.isDirectory())
        {
            printFile(dirName, 0);
        }
    }
    public static void printFile(String pathname, int indent)
    {
        File f1 = new File(pathname);
        if (f1.isDirectory())
        {
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++)
            {
                for (int j = 0; j < indent; j++)
                {
                    StdOut.print("-");
                }
                StdOut.println(s[i]);
                printFile(f1.getAbsolutePath() + "/" + s[i], indent + 4);
            }
        }
    }
}
