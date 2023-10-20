#include <stdlib.h>
#include <stdio.h>
#include <string.h>

// solution must allocate all required memory
// and return a free-able buffer to the caller.

char *disemvowel(const char *str)
{
    int len = strlen(str);
    char *res = (char *)malloc(len * sizeof(char));
    int i = 0;
    char c = *str;
    while (c != '\0')
    {
        char c_low = c | 0b100000;
        if (!(c_low == 'a' || c_low == 'e' || c_low == 'i' || c_low == 'o' || c_low == 'u'))
        {
            res[i] = c;
            i += 1;
        }
        str += 1;
        c = *str;
    }
    res[i] = '\0';
    return res;
}