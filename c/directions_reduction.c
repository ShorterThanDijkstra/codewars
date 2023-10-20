#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <stdio.h>

#define STACK_SIZE 1024

const char *SOUTH = "SOUTH";
const char *NORTH = "NORTH";
const char *WEST = "WEST";
const char *EAST = "EAST";

bool reducible(const char *top, const char *push) {
    if (strcmp(top, SOUTH) == 0) {
        return strcmp(push, NORTH) == 0;
    }
    if (strcmp(top, NORTH) == 0) {
        return strcmp(push, SOUTH) == 0;
    }
    if (strcmp(top, WEST) == 0) {
        return strcmp(push, EAST) == 0;
    }
    if (strcmp(top, EAST) == 0) {
        return strcmp(push, WEST) == 0;
    }
    return false;
}

const char **dirReduc(const char *const array[], int length_in, int *length_out) {
    /*
      Return a heap-allocated array of constant strings.
      Your array will be freed, but the strings will not be.
      Report the length of your array through the 'length_out' pointer.
    */
    if (length_in == 0) {
        *length_out = 0;
        return NULL;
    }
    const char **reduced = malloc(STACK_SIZE * sizeof(char *));
    reduced[0] = array[0];
    int index = 1;
    for (int i = 1; i < length_in; ++i) {
        if (index > 0 && reducible(reduced[index - 1], array[i])) {
            index -= 1;
        } else {
            reduced[index] = array[i];
            index += 1;
        }
    }
    *length_out = index;
    return reduced;
}

// int main() {
//     const char *arr[] = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
//     int len = 0;
//     const char **reduced = dirReduc(arr, 7, &len);
//     for (int i = 0; i < len; ++i) {
//         printf("%s\n", reduced[i]);
//     }
// }
