#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int compare_strings(const void *a, const void *b)
{
    return strcmp(*(const char **)a, *(const char **)b);
}
char **inArray(char *array1[], int sz1, char *array2[], int sz2, int *lg)
{
    char **res = (char **)malloc(sz1 * sizeof(char *));
    int res_ind = 0;
    for (int i = 0; i < sz1; i++)
    {
        for (int j = 0; j < sz2; j++)
        {
            if (strstr(array2[j], array1[i]))
            {
                int len = strlen(array1[i]) + 1;
                char *cpy = (char *)malloc(len * sizeof(char));
                strncpy(cpy, array1[i], len);
                res[res_ind] = cpy;
                res_ind += 1;
                break;
            }
        }
    }
    qsort(res, res_ind, sizeof(char *), compare_strings);
    *lg = res_ind;
    return res;
}

int main()
{
    char *arr1[3] = {"arp", "live", "strong"};
    char *arr2[5] = {"lively", "alive", "harp", "sharp", "armstrong"};
    int lg = 3;
    char **res = inArray(arr1, 3, arr2, 5, &lg);
    for (size_t i = 0; i < lg; i++)
    {
        printf("%s\n", res[i]);
    }
}