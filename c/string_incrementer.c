#include <stdlib.h>
#include <ctype.h>
#include <stdio.h>
#include <string.h>

char *incrementString(const char *str)
{
    int split = -1;
    int i = 0;
    while (str[i] != '\0')
    {
        if (isdigit(str[i]))
        {
            if (split == -1)
            {
                split = i;
            }
        }
        else
        {
            split = -1;
        }
        i += 1;
    }
    // printf("%d\n", split);
    // printf("%d\n", i);

    if (split == -1)
    {
        char *res = (char *)malloc((i + 2) * sizeof(char));
        strncpy(res, str, i);
        res[i] = '1';
        res[i + 1] = '\0';
        return res;
    }
    else
    {
        int trailing = atoi(str + split - 1) + 1;
        int leading_0 = 0;
        while (str[leading_0 + split] == '0')
        {
            leading_0 += 1;
        }
        if (leading_0 == 0)
        {
            printf("%d\n", split);
            int len = split + 
            char* sub = (char *) malloc(split  * sizeof(char));
            strncpy(sub, str, split);
            puts(sub);
            char *res = strcat(sub, itoa(trailing));
            puts(res);
        }
        
    }

    return NULL;
}
int main()
{
    char *s1 = "hell3";
    incrementString(s1);
    // puts(incrementString(s1));
    // char c = 'a';
    // printf("%d\n", atoi(s1+4));
}