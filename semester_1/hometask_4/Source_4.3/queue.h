#pragma once

struct QueueElement {
	int value;
	QueueElement *next = nullptr;
};

struct Queue {
	QueueElement *head = nullptr;
	QueueElement *tail = nullptr;
};

void clear(Queue &queue);

bool isEmpty(Queue &queue);

void push(Queue &queue, int value);
int pop(Queue &queue);

int front(Queue &queue);