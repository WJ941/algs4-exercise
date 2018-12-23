public class ResizingArrayQueueOfStrings {
    private int N;
    private String[] a = new String[0];
    private void resize(int size)
    {
        String[] temp = new String[size];
        for (int i = 0; i < temp.length; i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }
    public boolean isEmpty() { return N == 0;}
    public int size() { return N; }
    public void enqueue(String s)
    {
        if (N == a.length) resize(a.length * 2);
        a[N++] = s;
    }
    public String dequeue()
    {

        if (N == a.length / 4) resize(a.length / 2);
        String s = a[0];
        String[] temp = new String[a.length - 1];
        for (int i = 1; i < a.length; i++)
        {
            temp[i - 1] = a[i];
        }
        a = temp;
        return s;
    }
}
