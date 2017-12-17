#include "cycleList.h"
#include <iostream>

bool isEmpty(CycleList &list) {
	return list.top == nullptr;
}

void push(int value, CycleList &list) {
	list.size++;
	ListElement *newEl = new ListElement;
	newEl->value = value;
	newEl->next = nullptr;

	if (!isEmpty(list)) {
		if (list.top->next != nullptr) {
			list.last->next = newEl;
			newEl->next = list.top;
			list.top = newEl;
		}
		else {
			list.last = list.top;
			list.last->next = newEl;
			list.top = newEl;
			list.top->next = list.last;
		}
	}
	else {
		list.top = newEl;
	}
}

void remove(CycleList &list, int i) {
	ListElement *current = list.top;
	ListElement *previous = list.last;
	if (i != 0) {
		while (i > 0) {
			previous = current;
			current = current->next;
			i--;
		}

		previous->next = current->next;
		delete current;
	}
	else {
		list.last->next = list.top->next;
		delete list.top;
		list.top = list.last->next;
	}
	list.size--;
}

int get(CycleList &list, int i) {
	ListElement *current = list.top;
	while (i > 0) {
		current = current->next;
		i--;
	}

	return current->value;
}

void killEveryK(CycleList &list, int k) {
	ListElement *current = list.top;
	ListElement *previous = list.last;
	while (list.size > 1) {
		for (int i = 0; i < k; ++i) {
			previous = current;
			current = current->next;
		}

		previous->next = current->next;
		delete current;
		current = previous->next;

		list.size--;
	}

	list.top = current;
	list.last = current;
}


int getSize(CycleList &list) {
	return list.size;
}

void out(CycleList &list, char end) {
	for (int i = 0; i < list.size; ++i)
		std::cout << get(list, i) << " ";
	std::cout << end;
}

void clear(CycleList &list) {
	for (int i = 0; i < list.size; ++i)
		remove(list, 0);
}