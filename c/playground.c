//#include <stdio.h>
//#include <string.h>
//
//struct point {
//    int x;
//    int y;
//};
//
//void addpoint(struct point *p1, struct point *p2) {
//    p1->x += p2->x;
//    p1->y += p2->y;
//}
//
//void printstruct(struct point p) {
//    printf("{x: %d, y:%d}", p.x, p.y);
//}
//
//int main(int argc, char *argv[]) {
//    struct point p1 = {2, 3};
//    struct point p2 = {3, 4};
//    addpoint(&p1, &p2);
//    printstruct(p1);
//    char what[] = {'h', 'e', 'l', 'l', 'o'};
//    char *fuck = what;
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