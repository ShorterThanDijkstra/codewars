#include <stdlib.h>

int *parse(const char *program) {
    // return a heap-allocated int array
    // its length shall be at least equal to
    // the count of 'o' commands in the program
    int cap = 16;
    int *res = malloc(cap * sizeof(int));
    int value = 0;
    char c;
    for (int i = 0, j = 0; (c = program[i]) != '\0'; ++i) {
        if (j == 16) {
            cap = cap << 1;
            res = (int *) realloc(res, cap * sizeof(int));
        }
        if (c == 'i') {
            value += 1;
        } else if (c == 'd') {
            value -= 1;
        } else if (c == 's') {
            value *= value;
        } else if (c == 'o') {
            res[j] = value;
            j += 1;
        }
    }
    return res;
}




