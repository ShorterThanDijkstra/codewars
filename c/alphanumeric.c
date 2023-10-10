#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

bool alphanumeric(const char *strin) {
    int len = 0;
    while (*strin != '\0') {
        if (!isalnum(*strin)) {
            return false;
        }
        strin += 1;
        len += 1;
    }
    return len != 0;
}

//int main() {
//    bool res = alphanumeric("h_h");
//}