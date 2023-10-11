#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdio.h>
#define MAX_LEN 1024
#define BUFF_LEN 10

const char *morse[55] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-.-.-", "--..--", "..--..", ".----.", "-.-.--", "-..-.", "-.--.", "-.--.-", ".-...", "---...", "-.-.-.", "-...-", ".-.-.", "-....-", "..--.-", ".-..-.", "...-..-", ".--.-.", "...---..."};
const char *ascii[55] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", ",", "?", "'", "!", "/", "(", ")", "&", ":", ";", "=", "+", "-", "_", "\"", "$", "@", "SOS"};

int seach_code(char *code)
{
    for (int i = 0; i < 55; i++)
    {
        if (strcmp(code, morse[i]) == 0)
        {
            return i;
        }
    }
    return -1;
}
char *decode_morse(const char *morse_code)
{

    // trim
    size_t len = strlen(morse_code);
    while (isspace(morse_code[len - 1]))
    {
        len -= 1;
    }
    int start = 0;
    while (isspace(morse_code[start]))
    {
        start += 1;
    }

    char *res = (char *)malloc(MAX_LEN * sizeof(char));
    char *buff = (char *)malloc(BUFF_LEN * sizeof(char));
    int buff_ind = 0;

    while (start < len)
    {
        printf("%c\n", morse_code[start]);
        if (!isspace(morse_code[start]))
        {
            buff[buff_ind] = morse_code[start];
            buff_ind += 1;
            start += 1;
            continue;
        }
        printf("1 %d\n", start);

        puts(buff);
        buff[buff_ind] = '\0';
        int index = seach_code(buff);
        strcat(res, ascii[index]);
        buff_ind = 0;
        buff[buff_ind] = '\0';
        printf("2 %d\n", start);
        puts(res);

        start += 1;
        if (start < len - 1 && isspace(morse_code[start + 1]))
        {
            printf("3 %c", morse_code[start]);
            strcat(res, " ");
            start += 1;
        }
    }

    if (buff_ind != 0)
    {
        buff[buff_ind] = '\0';
        int index = seach_code(buff);
        strcat(res, ascii[index]);
    }

    return res;
}
int main()
{
    char *res = decode_morse(".... . -.--   .--- ..- -.. .");
    puts(res);
}