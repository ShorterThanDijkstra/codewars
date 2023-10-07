#include <math.h>
#include <stdlib.h>
#include <stdio.h>

void push_int(int **facs, int *cap, int i, int v) {
    if (i >= *cap) {
        *cap = *cap * 2;
        *facs = realloc(*facs, *cap * sizeof(int));
    }
    (*facs)[i] = v;
}

void push_char(char **facs, int *cap, int i, char v) {
    if (i >= *cap) {
        *cap = *cap * 2;
        *facs = realloc(*facs, *cap * sizeof(char));
    }
    (*facs)[i] = v;
}

void push_ints(char **str, int *cap, int *i, int v) {
    int len = (int) floor(log10((double) v)) + 1;
    *i = *i + len;

    int old_cap = *cap;
    while (*i >= *cap) {
        *cap = *cap * 2;
    }
    if (*cap > old_cap) {
        *str = realloc(*str, *cap * sizeof(char));
    }

    while (v > 0) {
        char c = v % 10 + '0';
        (*str)[*i - 1] = c;
        v /= 10;
        *i = *i - 1;
    }
    *i = *i + len;
}

int factors_int(int lst, int *cap, int **facs) {
    int fac = 2;
    int i = 0;
    while (fac < lst) {
        if (lst % fac == 0) {
            push_int(facs, cap, i, fac);
            lst = lst / fac;
            i += 1;
        } else {
            fac += 1;
        }
    }
    push_int(facs, cap, i, lst);
    return i;
}

void factors_char(const int *facs, char **res, int *cap_c, int cap_i) {
    int i_res = 0;
    int pre = facs[0];
    int n = 1;
    push_char(res, cap_c, i_res, '(');
    i_res += 1;
    push_ints(res, cap_c, &i_res, pre);
    int i = 1;
    while (i <= cap_i) {
        if (facs[i] == pre) {
            n += 1;
            i++;
            continue;
        }
        if (n == 1) {
            push_char(res, cap_c, i_res, ')');
            i_res += 1;
        } else {
            push_char(res, cap_c, i_res, '*');
            i_res += 1;
            push_char(res, cap_c, i_res, '*');
            i_res += 1;
            push_ints(res, cap_c, &i_res, n);
            push_char(res, cap_c, i_res, ')');
            i_res += 1;
        }
        pre = facs[i];
        n = 1;
        push_char(res, cap_c, i_res, '(');
        i_res += 1;
        push_ints(res, cap_c, &i_res, pre);
        i++;
    }
    if (n == 1) {
        push_char(res, cap_c, i_res, ')');
        i_res += 1;
    } else {
        push_char(res, cap_c, i_res, '*');
        i_res += 1;
        push_char(res, cap_c, i_res, '*');
        i_res += 1;
        push_ints(res, cap_c, &i_res, n);
        push_char(res, cap_c, i_res, ')');
        i_res += 1;
    }
    (*res)[i_res] = '\0';
}


char *factors(int lst) {
    int cap_i = 16;
    int *facs = (int *) malloc(cap_i * sizeof(int));
    int len = factors_int(lst, &cap_i, &facs);

    int cap_c = 16;
    char *res = (char *) malloc(cap_i * sizeof(char));
    factors_char(facs, &res, &cap_c, len);
    return res;
}

//int main() {
//    char name[][15] = {"Illegal month", "Jan", "Feb", "Mar"};
//
//}