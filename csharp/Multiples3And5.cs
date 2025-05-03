c class Kata
{
    public static int Solution(int value)
    {
        int sum = 0;
        for (int i = 2; i < value; i++)
        {
            if (i % 3 == 0 && i % 5 == 0)
            {
                sum += i;
                continue;
            }

            if (i % 3 == 0)
            {
                sum += i;
            }

            if (i % 5 == 0)
            {
                sum += i;
            }
        }

        return sum;
    }

    public static void Main(string[] args)
    {
        Console.WriteLine(Kata.Solution(200));
    }
}
