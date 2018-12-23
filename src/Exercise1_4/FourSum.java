package Exercise1_4;

public class FourSum {
    public static int fourSum(int[] a)
    {

        if (a.length < 4) return 0;
        int cnt = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                for (int m = j + 1; m < a.length; m++)
                    for (int n = m + 1; n < a.length; n++)
                        if (a[i] + a[j] + a[m] + a[n] == 0) cnt++;
        return cnt;
    }
}
