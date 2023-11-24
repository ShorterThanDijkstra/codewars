#include <stdio.h>
#include <stddef.h>
#include <stdbool.h>

bool parse_eyes(const char *str)
{
    return *str == ';' || *str == ':';
}

bool parse_optional_nose(const char *str)
{
    return *str == '-' || *str == '~';
}

bool parse_mouth(const char *str)
{
    return *str == 'D' || *str == ')';
}

bool is_smiley(const char *str)
{
    if (!parse_eyes(str))
    {
        return false;
    }
    str += 1;

    if (parse_optional_nose(str))
    {
        str += 1;
    }

    if (!parse_mouth(str))
    {
        return false;
    }
    str += 1;
    return *str == '\0';
}

size_t count_smileys(size_t length, const char *const array[length])
{
    size_t count = 0;
    for (size_t i = 0; i < length; i++)
    {
        if (is_smiley(array[i]))
        {
            count += 1;
        }
    }
    return count;
}

// int main()
// {
//     const char *const arr[] = {":D", ":~)", ";~D", ":)"};
//     printf("%ld\n", count_smileys(4, arr));
//     return 0;
// }