#include <stdio.h>
int format(char *time_string, int index, int value, char suffix)
{
    int len;
    if (value < 10)
    {
        len = sprintf(time_string + index, "0%d%c", value, suffix);
    }
    else
    {
        len = sprintf(time_string + index, "%d%c", value, suffix);
    }
    index = len + index;
    return index;
}
char *human_readable_time(unsigned seconds, char *time_string)
{
    unsigned ss = seconds % 60;
    unsigned mm = seconds / 60 % 60;
    unsigned hh = seconds / 3600;
    int index = 0;
    index = format(time_string, index, hh, ':');
    index = format(time_string, index, mm, ':');
    index = format(time_string, index, ss, '\0');
    return time_string; // return it
}

int main() {
    char time_string[1024];
    printf("%s\n", human_readable_time(3599, time_string));
    printf("%s\n", human_readable_time(45296, time_string));
}
