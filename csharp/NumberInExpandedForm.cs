using System.Collections.Generic; 
using System.Diagnostics;
using System.Text;

namespace Learn;

// https://www.codewars.com/kata/5842df8ccbd22792a4000245/train/csharp
public class NumberInExpandedForm
{
    public static string ExpandedForm(long num)
    {
        var stack = new Stack<long>();
        int zeros = 0;
        while (num > 0)
        {
            stack.Push(num % 10);
            num = num / 10;
            zeros += 1;
        }

        var builder = new StringBuilder();

        var pop = stack.Pop();
        Debug.Assert(pop != 0);
        builder.Append(pop);
        for (int i = 1; i < zeros; i++)
        {
            builder.Append(0);
        }

        zeros -= 1;
        while (stack.Count > 0)
        {
            pop = stack.Pop();
            if (pop == 0)
            {
                zeros -= 1;
                continue;
            }

            builder.Append(" + ");

            builder.Append(pop);
            for (int i = 1; i < zeros; i++)
            {
                builder.Append(0);
            }
            
            zeros -= 1;
        }

        return builder.ToString();
    }
}
