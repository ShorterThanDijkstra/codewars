#include <stdio.h>

long zeros(long n)
{
    long count = 0;
    for (long i = 5; n / i >= 1; i *= 5)
    {
        count += n / i;
    }
    return count;
}

//int main()
//{
//    long res = zeros(100000);
//    printf("%ld\n", res);
//}