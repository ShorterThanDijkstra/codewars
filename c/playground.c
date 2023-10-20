//// #include <stdio.h>
//// #include <string.h>
////
//// struct point {
////     int x;
////     int y;
//// };
////
//// void addpoint(struct point *p1, struct point *p2) {
////     p1->x += p2->x;
////     p1->y += p2->y;
//// }
////
//// void printstruct(struct point p) {
////     printf("{x: %d, y:%d}", p.x, p.y);
//// }
////
//// int main(int argc, char *argv[]) {
////     struct point p1 = {2, 3};
////     struct point p2 = {3, 4};
////     addpoint(&p1, &p2);
////     printstruct(p1);
////     char what[] = {'h', 'e', 'l', 'l', 'o'};
////     char *fuck = what;
//////    char x = (*fuck)++;
//////    char y = *(fuck++);
////    *fuck++ = '2';
////
//////    printf("%c\n%c", x, y);
////
////    int i = 0;
////    int j = i++ + i++; // 0+2 , 1+1
////    printf("%d ", j);
////
////}
//
//// #include <stdio.h>
//// #include <string.h>
//// #include <ctype.h>
//
//// int main()
////{
////     char *hello = "2222";
////     int t = *(hello + 1) == '\0';
////     printf("%d\n", t);
////     printf("%c\n",  hello[2] );
////
//// }
//
////#include <stdlib.h>
////#include <stdio.h>
////#include <string.h>
////char *arr[] = {"ba", "abc", "dbca", "edd", "abd", "eafa"};
////
////int compare(const void *a, const void *b)
////{
////    return strcmp(*(const char **)a, *(const char **)b);
////}
////int main()
////{
////    printf("The unsorted array is: \n");
////    for (int i = 0; i < 6; i++)
////    {
////        printf("%s ", arr[i]);
////    }
////    qsort(arr, 6, sizeof(char *), compare);
////    printf("\nThe sorted array is: \n");
////    for (int i = 0; i < 6; i++)
////    {
////        printf("%s ", arr[i]);
////    }
////    puts("\n");
////}
//
//// #include <stdlib.h>
//// #include <stdio.h>
//// #include <string.h>
//
//// char *arr[] = {"ba", "abc", "dbca", "edd", "abd", "eafa"};
//
//// int main() {
////     printf("The unsorted array is:\n");
////     for (int i = 0; i < 6; i++) {
////         printf("%s ", arr[i]);
////     }
//
////     qsort(arr, 6, sizeof(char *), (int (*)(const void *, const void *))strcmp);
//
////     printf("\nThe sorted array is:\n");
////     for (int i = 0; i < 6; i++) {
////         printf("%s ", arr[i]);
////     }
////     puts("\n");
//
////     return 0;
//// }
//
////#include <string.h>
////#include <stdlib.h>
////#include <stdio.h>
////int main()
////{
////    char *hello = "hello";
////    char *cpy = strdup(hello);
////    printf("%s\n", cpy);
////}
//
////#include <stdio.h>
////#include <stdarg.h>
////
////void minprintf(char *fmt, ...) {
////    va_list ap;
////    char *p, *sval;
////    int ival;
////    double dval;
////
////    va_start(ap, fmt);
////    for (p = fmt; *p!='\0'; p++) {
////        if (*p != '%') {
////            putchar(*p);
////            continue;
////        }
////        switch (*++p) {
////            case 'd':
////                ival = va_arg(ap, int);
////                printf("%d", ival);
////                break;
////            case 'f':
////                dval = va_arg(ap, double);
////                printf("%f", dval);
////            case 's':
////                for (sval = va_arg(ap, char *); *sval; sval++) {
////                    putchar(*sval);
////                }
////                break;
////            default:
////                putchar(*p);
////                break;
////        }
////    }
////}
////
////int add(int first, ...) {
////    int sum = first;
////    va_list args;
////    va_start(args, first);
////    int num = va_arg(args, int);
////    while (num != 0) {
////        sum += num;
////        num = va_arg(args, int);
////    }
////    va_end(args);
////    return sum;
////}
////
////int main() {
////    minprintf("this is a number: %d", add(1, 2, 3, 4, 0));
////}
////#include <stdio.h>
////
////int main() {
////    double sum, v;
////    sum = 0;
////    while (scanf("add %lf", &v) == 1) {
////        printf("\t%.2f\n", sum += v);
////    }
////    int sc = scanf("add %lf", &v);
////    printf("%d", sc);
////    return 0;
//////    miscellaneous
////}
//#include <stdlib.h>
//#include <stdio.h>
//#include <string.h>
//
//#define MAX 1024
//
//int main(int argc, char **argv) {
//    if (argc == 1) {
//        return 0;
//    }
//    char *cmd = (char *) malloc(MAX * sizeof(char));
//    int index = 0;
//    while (argc > 1) {
//        argv += 1;
//        argc -= 1;
//        int len = sprintf(cmd + index, "%s ", *argv);
//        index += len;
//    }
//    printf("executing: %s ", cmd);
//    system(cmd);
//}

// #include <stdio.h>

// int add1(int n) {
//   n+1;
// }
// int main() {
//     printf("%d\n", add1(10));
// }