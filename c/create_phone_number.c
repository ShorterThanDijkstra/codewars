#include <stdio.h>
char *create_phone_number(char phnum[15], const unsigned char nums[10])
{
    int left_paren = 0;
    int right_paren = 4;
    int space = 5;
    int dash = 9;
    int phnum_index = 0;
    int nums_index = 0;
    while (phnum_index < 14) {
        if (phnum_index == left_paren) {
            phnum[phnum_index] = '(';
        }
        else if (phnum_index == right_paren) {
            phnum[phnum_index] = ')';
        }
        else if (phnum_index == space) {
            phnum[phnum_index] = ' ';
        }
        else if (phnum_index == dash) {
            phnum[phnum_index] = '-';
        }
        else {
            phnum[phnum_index] = nums[nums_index] + '0';
            nums_index += 1;
        }
        phnum_index += 1;
    }
    phnum[phnum_index] = '\0';
    // return phnum;
}

// int main()
// {
//     char nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//     char phone[15];
//     printf("%s\n", create_phone_number(phone, nums));
// }