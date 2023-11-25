#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX_LEN 1024
struct Node {
    int val;
    struct Node *pre;
    struct Node *next;
};

struct Node *new_node(int val) {
    struct Node *node = (struct Node *) malloc(sizeof(struct Node));
    node->val = val;
    return node;
}

struct Node *parse(const char *str) {
    struct Node *curr = new_node(*str - '0');
    struct Node *tail = curr;
    str += 1;
    while (*str != '\0') {
        struct Node *next = new_node(*str - '0');
        next->pre = curr;
        curr->next = next;
        curr = next;
        tail = curr;
        str += 1;
    }
    return tail;
}

struct Node *add_nodes(struct Node *tail1, struct Node *tail2) {
    // assume length of tail1 >= length of tail2
    int carry = 0;
    struct Node *tail1_pre = NULL;
    while (tail2 != NULL) {
        int val = tail1->val + tail2->val + carry;
        carry = val / 10;
        val = val % 10;
        tail1->val = val;
        tail1_pre = tail1;
        tail1 = tail1->pre;
        tail2 = tail2->pre;
    }
    while (tail1 != NULL) {
        int val = tail1->val + carry;
        carry = val / 10;
        val = val % 10;
        tail1->val = val;
        tail1_pre = tail1;
        tail1 = tail1->pre;
    }

    tail1 = tail1_pre;
    if (carry > 0) {
        struct Node *head = new_node(carry);
        head->next = tail1;
        tail1->pre = head;
        return head;
    }
    return tail1;
}

char *to_str_nodes(struct Node *head) {
    char *res = (char *) malloc(MAX_LEN * sizeof(char));
    int i = 0;
    while (head != NULL) {
        res[i] = (char) (head->val + '0');
        i += 1;
        head = head->next;
    }
    res[i] = '\0';
    return res;
}

char *add(const char *a, const char *b) {
    if (strlen(a) == 0) {
        return (char *) b;
    }
    if (strlen(b) == 0) {
        return (char *) a;
    }
    if (strlen(a) < strlen(b)) {
        const char *tmp = a;
        a = b;
        b = tmp;
    }
    struct Node *tail1 = parse(a);
    struct Node *tail2 = parse(b);
    struct Node *added = add_nodes(tail1, tail2);
    return to_str_nodes(added);
}

int main() {
//    struct Node *tail = parse("123");
//    while (tail != NULL) {
//        printf("%d\n", tail->val);
//        tail = tail->pre;
//    }
    puts(add("9956", "9123"));
}