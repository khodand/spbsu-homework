#include "cycleList.h"
#include <iostream>

void createCList(cList &A) {
	cList *newCList = new cList;
	newCList->top = nullptr;
	newCList->last = newCList->top;
	newCList->size = 0;

	A = *newCList;
}

bool isEmpty(cList &A) {
	return A.top == nullptr;
}

void push(int value, cList &A) {
	A.size++;
	listEl *newEl = new listEl;
	newEl->value = value;
	newEl->next = nullptr;

	if (!isEmpty(A)) {
		if (A.top->next != nullptr) {
			A.last->next = newEl;
			newEl->next = A.top;
			A.top = newEl;
		}
		else {
			A.last = A.top;
			A.last->next = newEl;
			A.top = newEl;
			A.top->next = A.last;
		}
	}
	else {
		A.top = newEl;
	}
}

void remove(cList &A, int i) {
	A.size--;
	listEl *curEl = A.top;
	listEl *prevEl = A.last;
	if (i != 0) {
		while (i > 0) {
			prevEl = curEl;
			curEl = curEl->next;
			i--;
		}

		prevEl->next = curEl->next;
		curEl = nullptr;
	}
	else {
		A.last->next = A.top->next;
		A.top = A.top->next;
	}
}

int get(cList &A, int i) {
	listEl *curEl = A.top;
	while (i > 0) {
		curEl = curEl->next;
		i--;
	}

	return curEl->value;
}

void out(cList &A, char end) {
	for (int i = 0; i < A.size; ++i)
		std::cout << get(A, i) << " ";
	std::cout << end;
}

void clear(cList &A) {
	for (int i = 0; i < A.size; ++i)
		remove(A, 0);
}