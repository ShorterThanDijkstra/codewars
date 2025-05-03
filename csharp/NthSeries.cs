
public class NthSeries
{
    public static string seriesSum(int n)
    {
        double sum = 0;
        double dom = 1;
        for (int i = 1; i <= n; i++)
        {
            sum += 1.0 / dom;
            dom += 3;
        }
        return sum.ToString("F2");
    }
}
