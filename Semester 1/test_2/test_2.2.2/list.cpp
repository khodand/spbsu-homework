#include "list.h"

void add(List &list, int value) {
	Node *newNode = new Node;
	newNode->value = value;

	if (isEmpty(list)) {
		list.head = newNode;
		list.head->next = list.tail;

		list.tail = newNode;
		list.tail->prev = list.head;
	}
	else {
		Node *tmp = list.tail;
		list.tail = newNode;
		list.tail->prev = tmp;
		tmp->next = list.tail;
	}

	list.size++;
}


bool isSymmetric(List list) {
	if (isEmpty(list))
		return true;

	Node *leftEnd = list.head;
	Node *rightEnd = list.tail;
	int neededSteps = list.size / 2;
	int steps = 0;

	while (steps++ <= neededSteps) {
		if (leftEnd->value != rightEnd->value)
			return false;

		leftEnd = leftEnd->next;
		rightEnd = rightEnd->prev;
	}

	return true;
}

bool isEmpty(List list) {
	return list.size == 0;
}


void clear(List &list) {
	Node *curNode = list.tail;
	Node *nextNode = nullptr;
	while (curNode != list.head) {
		nextNode = curNode->prev;
		delete curNode;
		curNode = nextNode;
	}
	delete curNode;

	list.size = 0;
}