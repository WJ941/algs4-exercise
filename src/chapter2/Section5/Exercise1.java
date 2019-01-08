package chapter2.Section5;

public class Exercise1
{
    public int CompareTo(String a, String b)
    {
        if (a.equals(b)) return 0;
        int n = Math.min(a.length(), b.length());
        for (int i = 0; i < n; i++)
        {
            if (a.charAt(i) < b.charAt(i)) return -1;
            else if (a.charAt(i) > b.charAt(i)) return 1;
        }
        return a.length() - b.length();
    }
}
