import edu.princeton.cs.algs4.StdIn;

public class Parentheses {
    public static boolean main(String[] args)
    {
        while(!StdIn.isEmpty())
        {
            String[] s = StdIn.readAll().split("");
            Stack<String> parentheses = new Stack<>();
            for (int i = 0; i < s.length; i++)
            {
                if (s[i].equals("[")
                    || s[i].equals("(")
                    || s[i].equals("{")
                )
                {
                    parentheses.push(s[i]);
                }
                else if (s[i].equals("]"))
                {
                    if (!parentheses.pop().equals("[")) return false;
                }
                else if (s[i].equals(")"))
                {
                    if (!parentheses.pop().equals("(")) return false;
                }
                else if (s[i].equals("}"))
                {
                    if (!parentheses.pop().equals("{")) return false;
                }
            }
        }
        return true;
    }
}
