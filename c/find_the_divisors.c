#include <stddef.h>
#include <stdio.h>
//  assign divisors to array[]
//  set *length to the number of divisors
void divisors(unsigned n, size_t *length, unsigned array[])
{

    size_t len = 0;
    for (unsigned i = 2; i < n - 1; i++)
    {
        if (n % i == 0)
        {
            array[len] = i;
            len += 1;
        }
    }
    *length = len;
}
int main()
{
    int n = 5;
    unsigned arr[n];
    size_t len = 0;
    divisors(n, &len, arr);
    // printf("%d\n", arr);

    for (size_t i = 0; i < len; i++)
    {
        printf("%d\n", arr[i]);
    }
}