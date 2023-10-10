#include <stdlib.h>
#include <ctype.h>
#include <stdio.h>

#define MAX_LENGTH 1024

char *camel_case(const char *s) {
    char *res = malloc(sizeof(char) * MAX_LENGTH);
    int i = 0;
    int up = 1;
    while (*s != '\0') {
        if (isspace(*s)) {
            up = 1;
            s += 1;
            continue;
        }
        if (up == 1) {
            res[i] = toupper(*s);
            up = 0;
        } else {
            res[i] = *s;
        }
        i += 1;
        s += 1;
    }
    res[i] = '\0';
    return res;
}

//int main() {
//    printf("%s", camel_case("hello case"));
//}