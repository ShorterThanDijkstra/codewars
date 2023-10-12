#include <stdlib.h>
#include <ctype.h>
#include <stdio.h>

char *incrementString(const char *str)
{
    const char *num_head = NULL;
    while (*str != '\0')
    {
        printf("%s\n", num_head);
        if (isdigit(*str) && num_head == NULL)
        {
            num_head = str;
        }
        else
        {
            num_head = NULL;
        }
        str += 1;
    }
    return (char *)num_head;
}
int main()
{
    char *s1 = "hell92h00901";
    printf("%s\n", incrementString(s1));
    // char c = 'a';
    // printf("%d\n", isdigit(c));
}