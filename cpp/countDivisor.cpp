// https://www.codewars.com/kata/542c0f198e077084c0000c2e/train/cpp
#include <iostream>
int divisors(long long n)
{
    int res = 1;
    long long idx = 2;
    long long count = 1;
    while (idx <= n)
    {
        if (n % idx == 0)
        {
            count += 1;
            n = n / idx;
        } else {
            res = res * count;
            count = 1;
            while (n % idx != 0)
            {
                idx += 1;
            }
        }
    }
    res = res * count;
    return res;
}

int main()
{
    std::cout << divisors(5) << std::endl;
}