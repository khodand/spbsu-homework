#include "cycleList.h"
#include <iostream>

void createCycleList(CycleList &A) {
	CycleList *newList = new CycleList;
	newList->top = nullptr;
	newList->last = newList->top;
	newList->size = 0;

	A = *newList;
	delete newList;
}

bool isEmpty(CycleList &A) {
	return A.top == nullptr;
}

void push(int value, CycleList &A) {
	A.size++;
	ListEl *newEl = new ListEl;
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

void remove(CycleList &A, int i) {
	A.size--;
	ListEl *curEl = A.top;
	ListEl *prevEl = A.last;
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

int get(CycleList &A, int i) {
	ListEl *curEl = A.top;
	while (i > 0) {
		curEl = curEl->next;
		i--;
	}

	return curEl->value;
}

int getSize(CycleList &A) {
	return A.size;
}

void out(CycleList &A, char end) {
	for (int i = 0; i < A.size; ++i)
		std::cout << get(A, i) << " ";
	std::cout << end;
}

void clear(CycleList &A) {
	for (int i = 0; i < A.size; ++i)
		remove(A, 0);
}