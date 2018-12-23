public class StopWatch {
    private long begin;
    public StopWatch()
    {
        begin = System.currentTimeMillis();

    }
    public double elapseTime()
    {
        return (System.currentTimeMillis() - begin) / 1000;
    }
}
