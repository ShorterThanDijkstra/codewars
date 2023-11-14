#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int count_words(const char *words) {
    int count = 0;
    while (*words == ' ') {
        words += 1;
    }
    char pre = '\0';
    while (*words != '\0') {
        pre = *words;
        if (*words == ' ') {
            count += 1;
            while (*words == ' ') {
                words += 1;
            }
        } else {
            words += 1;
        }
    }
    if (pre != ' ') {
        count += 1;
    }
    return count;
}

const char *parse_word(const char *words, char **words_sorted) {
    while (*words == ' ') {
        words += 1;
    }
    int end = 0;
    int num = 0;
    char c = *words;
    while (c != '\0' && c != ' ') {
        if (!(c <= '9' && c >= '0')) {
            end += 1;
            c = *(words + end);
        }
        while (c <= '9' && c >= '0') {
            num = num * 10 + (c - '0');
            end += 1;
            c = *(words + end);
        }
    }
    char *word = (char *) malloc(end * sizeof(char));
    strncpy(word, words, end);
    words_sorted[num - 1] = word;
    return words + end;
}

char *order_words(char *ordered, const char *words) {
    if (strlen(words) == 0) {
        ordered[0] = '\0';
        return ordered;
    }
    // ordered is pre-allocated and has enough room for a trailing space character ' '
    // but dont forget to trim it !
    // write to ordered and return it
    int words_count = count_words(words);
    char **words_sorted = (char **) malloc(words_count * sizeof(char *));
    while (*words != '\0') {
        words = parse_word(words, words_sorted);
    }
    int index = 0;
    for (int i = 0; i < words_count; ++i) {
        index += sprintf(ordered + index, "%s ", words_sorted[i]);
    }
    ordered[index - 1] = '\0';
    return ordered;
}

int main() {
    char *words;
    char *ordered;

    words = "is2 Thi1s T4est 3a ";
    ordered = (char *) malloc(strlen(words) * sizeof(char));
    puts(order_words(ordered, words));

    words = "";
//    ordered = (char *) malloc(strlen(words) * sizeof(char));
    puts(order_words(ordered, words));

    words = "3 6 4 2 8 7 5 1 9";
    ordered = (char *) malloc(strlen(words) * sizeof(char));
    puts(order_words(ordered, words));
}

// #include<stdio.h>
// #include <string.h>

// int main() {
//    char string[50] = "Hello world";
//    // Extract the first token
//    char * token = strtok(string, " ");
//    printf( " %s\n", token ); //printing the token
//    return 0;
// }

// #include<stdio.h>
// #include <string.h>

// int main() {
//    char string[50] = "Hello! We are learning about strtok";
//    // Extract the first token
//    char * token = strtok(string, " ");
//    // loop through the string to extract all other tokens
//    while( token != NULL ) {
//       printf( " %s\n", token ); //printing each token
//       token = strtok(NULL, " ");
//    }
//    return 0;
// }