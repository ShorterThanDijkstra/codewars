#include <stdlib.h>
#include <string.h>
#include <stdio.h>

char *DuplicateEncoder(const char *string)
{
    char map[128] = {0};
    size_t len = strlen(string);
    char *res = (char *)malloc((len + 1) * sizeof(char));
    for (size_t i = 0; i < len; i++)
    {
        unsigned int c = (unsigned int)string[i];
        // to lower case
        if (c <= 90 && c >= 65)
        {
            c += 32;
        }
        map[c] = map[c] + 1;
    }
    for (size_t i = 0; i < len; i++)
    {
        unsigned int c = (unsigned int)string[i];
        if (c <= 90 && c >= 65)
        {
            c += 32;
        }
        if (map[c] == 1)
        {
            res[i] = '(';
        }
        else
        {
            res[i] = ')';
        }
    }
    res[len] = '\0';

    return res;
}

int main()
{
    char *res = DuplicateEncoder("ac73a4c<ij^`=kcMd>7110?ZQjS(3c9e7 77TlZeUN//a{0dSQfV2=?`i%eM`PQXfZeb)4f7S3d?b*1U5hRfhlY`a4eT<}TZVX183");
    printf("%c\n", res[61]);
}
// ac73a4c<ij^`=kcMd>7110?ZQjS(3c9e7 77TlZeUN//a{0dSQfV2=?`i%eM`PQXfZeb)4f7S3d?b*1U5hRfhlY`a4eT<}TZVX183
// ))))))))))())()))()))))))))())())()))))))()))())))))())))()))())))))())))))))())()()))())))))()))))()
// ))))))))))())()))()))))))))())())()))))))))))())))))())))())))))))))())))))))())())))))))))))()))))()