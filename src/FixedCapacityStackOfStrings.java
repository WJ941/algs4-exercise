public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N = 0;
    public FixedCapacityStackOfStrings(int cap)
    {
        a = new String[cap];
    }
    public void push(String item)
    {
        a[N++] = item;
    }
    public String pop()
    {
        return a[--N];
    }
}
