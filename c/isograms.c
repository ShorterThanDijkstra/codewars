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
