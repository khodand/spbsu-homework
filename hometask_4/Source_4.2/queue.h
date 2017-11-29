#pragma once

struct QueueElement {
	int value;
	QueueElement *next;
};

struct Queue {
	QueueElement *head;
	QueueElement *tail;
};

void createQueue(Queue &queue);
void clear(Queue &queue);

bool isEmpty(Queue &queue);

void push(Queue &queue, int value);
int pop(Queue &queue);

int front(Queue &queue);