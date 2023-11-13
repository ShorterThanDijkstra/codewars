#include <ctype.h>
#include <stdio.h>
#include <stdbool.h>

bool is_pangram(const char *str_in)
{
    bool exist[26] = {false};
    while (*str_in != '\0')
    {
        unsigned char c = *str_in;

        if (!((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')))
        {
            str_in += 1;
            continue;
        }
        unsigned char c_low = tolower(c) - 'a';
        exist[c_low] = true;
        str_in += 1;
    }
    for (size_t i = 0; i < 26; i++)
    {
        if (!exist[i])
        {
            return false;
        }
    }

    return true;
}
int main()
{
    char *str_in = "abcdefghijklmnopqrstuvwxy";
    int test = is_pangram(str_in);
    printf("%d\n", test);
    return 0;
}