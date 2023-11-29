// https://www.codewars.com/kata/52bef5e3588c56132c0003bc/train/c
#include <stddef.h>
#include <stdlib.h>
/* to help you solve the kata, a queue implementation has been
preloaded for you */

typedef struct Queue Queue;

// the queue elements are pointers

// creates a new queue
extern Queue *new_queue(void);
// returns the number of elements in the queue
extern size_t queue_size(const Queue *queue);
// adds an element at the back of the queue and returns the queue
extern Queue *queue_enqueue(Queue *queue, const void *data);
// removes the element at the front of the queue and returns it
extern void *queue_dequeue(Queue *queue);
// frees the queue, do not forget to call it !
extern void free_queue(Queue *queue);
/* ==================================================== */

typedef struct Tree
{
    struct Tree *left, *right;
    int value;
} Tree;

int *tree_by_levels(const Tree *tree, size_t *tree_size)
{
    if (tree == NULL)
    {
        *tree_size = 0;
        return NULL;
    }

    *tree_size = 0; // report the tree size
    Queue *node_que = new_queue();
    Queue *int_que = new_queue();
    queue_enqueue(node_que, tree);
    while (queue_size(node_que) != 0)
    {
        tree = queue_dequeue(node_que);
        *tree_size += 1;
        queue_enqueue(int_que, (const void *)tree->value);

        if (tree->left != NULL)
        {
            queue_enqueue(node_que, (const void *)tree->left);
        }
        if (tree->right != NULL)
        {
            queue_enqueue(node_que, (const void *)tree->right);
        }
    }
    int *arr = (int *)malloc(*tree_size * sizeof(int));
    int i = 0;
    while (queue_size(int_que) != 0)
    {
        arr[i] = (int) queue_dequeue(int_que);
        i++;
    }
    free_queue(int_que);
    free_queue(node_que);
    return arr; // return a heap-allocated array, it will be freed
}