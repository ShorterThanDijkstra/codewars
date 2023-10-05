#include <stdbool.h>
#include <string.h>
#include <stdio.h>

bool IsIsogram(const char *string) {
    bool exists[26] = {false};
    for (size_t i = 0; i < strlen(string); ++i) {
        char c = string[i];
        if (c <= 'Z' && c >= 'A') {
            c += 32;
        }
        int exist = exists[c - 'a'];
        if (exist) {
            return false;
        } else {
            exists[c - 'a'] = true;
        }
    }
    return true;
}

void _strcpy(char *s, char *t)
{
    int i = 0;
    while ((s[i] = t[i]) != '\0')
    {
        i++;
    }
}
char *lineptr[100];
int main()
{
    char s2[] = "34567";
    char s1[] = "123";
    _strcpy(s1, s2);
    printf("s1:%s\n", s1);
    printf("s2:%s\n", s2);

    return 0;
}