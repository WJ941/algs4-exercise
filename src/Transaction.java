import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

public class Transaction implements Comparable<Transaction> {
    private final String who;
    private final Date when;
    private final double amount;
    public Transaction(String w, Date d, double a)
    {
        who = w;
        when = d;
        amount = a;
    }
    public Transaction(String transaction)
    {
        String[] args = transaction.split("\\s+");
        who = args[0];
        when = new Date(args[1]);
        amount = Double.parseDouble(args[2]);
    }
    public String who()
    {
        return who;
    }
    public Date when()
    {
        return when;
    }
    public double amount()
    {
        return amount;
    }
    public String toString()
    {
        return who + " at " + when.toString() + " transaction " + amount;
    }
    public boolean equals(Object x)
    {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (!this.who.equals(that.who)) return false;
        if (!this.when.equals(that.when)) return false;
        if (this.amount != that.amount) return false;
        return true;
    }
    public int compareTo(Transaction that)
    {
        return this.amount() - that.amount() > 0 ? 1 : 0;
    }
    public int hashCode()
    {
        return 0;
    }
    public static void main(String[] args)
    {
        Transaction t1 = new Transaction("Blondie", new Date(2, 29, 2008), 100);
        Transaction t2 = new Transaction("Blondie 2/29/2008 200");
        StdOut.println(t1.who());
        StdOut.println(t1.when());
        StdOut.println(t1.amount());
        StdOut.println(t1);
        StdOut.println(t1.equals(t2));
        StdOut.println(t1.compareTo(t2));

        StdOut.println("test t2:");
        StdOut.println(t2.who());
        StdOut.println(t2.when());
        StdOut.println(t2.amount());
        StdOut.println(t2);
        StdOut.println(t2.equals(t1));
        StdOut.println(t2.compareTo(t1));

        StdOut.println("test equal:");
        StdOut.println(t2.equals(t2));
    }
}
