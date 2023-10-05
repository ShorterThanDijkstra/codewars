#include <stdio.h>
#include <string.h>

char *maskify(char *masked, const char *string) {
    size_t len = strlen(string);
    strncpy(masked, string, len);
    if (len <= 4) {
        masked[len] = '\0';
        return masked;
    }
    for (size_t i = 0; i < len - 4; ++i) {
        masked[i] = '#';
    }
    masked[len] = '\0';
    return masked;
}
