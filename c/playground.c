// #include <stdio.h>
// #include <string.h>
//
// struct point {
//     int x;
//     int y;
// };
//
// void addpoint(struct point *p1, struct point *p2) {
//     p1->x += p2->x;
//     p1->y += p2->y;
// }
//
// void printstruct(struct point p) {
//     printf("{x: %d, y:%d}", p.x, p.y);
// }
//
// int main(int argc, char *argv[]) {
//     struct point p1 = {2, 3};
//     struct point p2 = {3, 4};
//     addpoint(&p1, &p2);
//     printstruct(p1);
//     char what[] = {'h', 'e', 'l', 'l', 'o'};
//     char *fuck = what;
////    char x = (*fuck)++;
////    char y = *(fuck++);
//    *fuck++ = '2';
//
////    printf("%c\n%c", x, y);
//
//    int i = 0;
//    int j = i++ + i++; // 0+2 , 1+1
//    printf("%d ", j);
//
//}

// #include <stdio.h>
// #include <string.h>
// #include <ctype.h>

// int main()
//{
//     char *hello = "2222";
//     int t = *(hello + 1) == '\0';
//     printf("%d\n", t);
//     printf("%c\n",  hello[2] );
//
// }

// #include <stdlib.h>
// #include <stdio.h>
// #include <string.h>
// char *arr[] = {"ba", "abc", "dbca", "edd", "abd", "eafa"};

// int compare_strings(const void *a, const void *b)
// {
//     return strcmp(*(const char **)a, *(const char **)b);
// }
// int main()
// {
//     printf("The unsorted array is: \n");
//     for (int i = 0; i < 6; i++)
//     {
//         printf("%s ", arr[i]);
//     }
//     qsort(arr, 6, sizeof(char *), compare_strings);
//     printf("\nThe sorted array is: \n");
//     for (int i = 0; i < 6; i++)
//     {
//         printf("%s ", arr[i]);
//     }
//     puts("\n");
// }

// #include <stdlib.h>
// #include <stdio.h>
// #include <string.h>

// char *arr[] = {"ba", "abc", "dbca", "edd", "abd", "eafa"};

// int main() {
//     printf("The unsorted array is:\n");
//     for (int i = 0; i < 6; i++) {
//         printf("%s ", arr[i]);
//     }

//     qsort(arr, 6, sizeof(char *), (int (*)(const void *, const void *))strcmp);

//     printf("\nThe sorted array is:\n");
//     for (int i = 0; i < 6; i++) {
//         printf("%s ", arr[i]);
//     }
//     puts("\n");

//     return 0;
// }

#include <string.h>
#include <stdlib.h>
#include <stdio.h>
int main()
{
    char *hello = "hello";
    char *cpy = strdup(hello);
    printf("%s\n", cpy);
}