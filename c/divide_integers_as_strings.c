// https://www.codewars.com/kata/58dea43ff98a7e2124000169/train/c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char **divide_strings(char *a, char *b)
{
    // An approach that definitely won't get past 2^64 - 1 ;)
    // Just try executing the Submit Tests - they won't get past
    // the later half of the random tests
    // TODO: Rewrite this and come up with a better approach
    // which works for arbitrarily large integers
    // char **result = malloc(2 * sizeof(char *));
    // char quotient[21], remainder[21];
    // sprintf(quotient, "%llu", strtoull(a, NULL, 10) / strtoull(b, NULL, 10));
    // sprintf(remainder, "%llu", strtoull(a, NULL, 10) % strtoull(b, NULL, 10));
    // *result = malloc((strlen(quotient) + 1) * sizeof(char));
    // *(result + 1) = malloc((strlen(remainder) + 1) * sizeof(char));
    // for (unsigned long i = 0; i < strlen(quotient); i++)
    //     *(*result + i) = quotient[i];
    // for (unsigned long i = 0; i < strlen(remainder); i++)
    //     *(*(result + 1) + i) = remainder[i];
    // *(*result + strlen(quotient)) = *(*(result + 1) + strlen(remainder)) = '\0';
    // return result;
}