package chapter2.Section4;

public class Exercise19<key extends Comparable<key>>
{
    private key[] pq;
    public Exercise19(key[] a)
    {
        int N = a.length;
        pq = (key[]) new Comparable[N+1];
        for (int i = 0 ; i < N; i++)
            pq[i+1] = a[i];
        for (int i = N/2; i >= 1; i--)
        {
            // sink(i);
        }
    }
    public static void main(String[] args)
    {
        Integer[] a = {1,2,3,4,5,6, 7};
        MaxPQ<Integer> pq = new MaxPQ<>(a);
        pq.show();
    }
}
