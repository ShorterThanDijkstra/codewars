#include <stdlib.h>
#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <math.h>

char *incrementString(const char *str) {
    int split = -1;
    int i = 0;
    while (str[i] != '\0') {
        if (isdigit(str[i])) {
            if (split == -1) {
                split = i;
            }
        } else {
            split = -1;
        }
        i += 1;
    }

    if (split == -1) {
        char *res = (char *) malloc((i + 2) * sizeof(char));
        strncpy(res, str, i);
        res[i] = '1';
        res[i + 1] = '\0';
        return res;
    } else {
        int trailing = atoi(str + split) + 1;
        int trailing_len = (int) floor(log10((double) trailing)) + 1;
        int leading_0 = 0;
        while (str[leading_0 + split] == '0') {
            leading_0 += 1;
        }
        if (leading_0 == 0) {
            char *res = (char *) malloc(split + trailing_len * sizeof(char));
            strncpy(res, str, split);
            sprintf(res + split, "%d", trailing);
            return res;
        } else {
            char *res = (char *) malloc(i * sizeof(char));
            strncpy(res, str, split);
            int trailing_len_before_add = (int) floor(log10( trailing - 1.0)) + 1;

            if (trailing_len_before_add < trailing_len) {
                // 进位
                leading_0 -= 1;
            }
            int j = 0;
            for (; j < leading_0; ++j) {
                res[j + split] = '0';
            }
            sprintf(res + split + j, "%d", trailing);
            return res;
        }

    }
}

//int main() {
//    char *s1 = "hell09";
//    incrementString(s1);
//     puts(incrementString(s1));
//    // char c = 'a';
//    // printf("%d\n", atoi(s1+4));
//}