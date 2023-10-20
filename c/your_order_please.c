#include <string.h>
#define ARR_MAX 1024
char *order_words(char *ordered, const char *words)
{
	// ordered is pre-allocated and has enough room for a trailing space character ' '
	// but dont forget to trim it !
	// write to ordered and return it
	char *splited = strtok(words);
	
	return ordered;
}
int main()
{
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