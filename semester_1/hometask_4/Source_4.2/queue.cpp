#include "queue.h"

const int error = -2147483646;

QueueElement* createQueueElement(int value) {
	QueueElement *newElement = new QueueElement;
	newElement->next = nullptr;
	newElement->value = value;

	return newElement;
}

void clear(Queue &queue) {
	while (!isEmpty(queue))
		pop(queue);
}

bool isEmpty(Queue &queue) {
	return queue.tail == nullptr;
}

void push(Queue &queue, int value) {
	QueueElement *newElement = createQueueElement(value);

	if (isEmpty(queue)) {
		queue.head = newElement;
		queue.tail = newElement;
	}
	else {
		queue.tail->next = newElement;
		queue.tail = newElement;
	}
}

int pop(Queue &queue) {
	if (isEmpty(queue))
		return error;
	if (queue.head == queue.tail)
		queue.tail = nullptr;

	int result = queue.head->value;
	QueueElement *temp = queue.head;
	queue.head = queue.head->next;

	delete temp;
	return result;
}

int front(Queue &queue) {
	if (isEmpty(queue))
		return error;

	return queue.head->value;
}
