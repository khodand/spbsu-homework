#include "cList_2.0.h"

void push(int value, CycleList &list) {
	if (isEmpty(list)) {
		list.current = new ListElement;
		list.current->value = value;

		list.current->next = list.current;
		list.current->prev = list.current;
	}
	else {
		ListElement *newElement = new ListElement;
		newElement->value = value;

		newElement->next = list.current->next;
		list.current->next->prev = newElement;
		newElement->prev = list.current;
		list.current->next = newElement;

		list.current = newElement;
	}
	list.size++;
}

void remove(CycleList &list, int i) {
	if (isEmpty(list))
		return;

	for (int k = 0; k < i; ++k)
		list.current = list.current->next;

	list.current->prev->next = list.current->next;
	list.current->next->prev = list.current->prev;

	ListElement *temp = list.current->next;
	delete list.current;
	list.current = temp;

	list.size--;

	if (list.size == 0)
		list.current = nullptr;
}

int get(CycleList &list, int i) {
	for (int k = 0; k < i; ++k)
		list.current = list.current->next;

	return list.current->value;
}

int getSize(CycleList &list) {
	return list.size;
}

bool isEmpty(CycleList list) {
	return list.current == nullptr;
}

void out(CycleList &list, int add) {
	for (int i = 0; i < list.size; ++i) {
		std::cout << list.current->value + add << " ";
		list.current = list.current->next;
	}
	std::cout << std::endl;
}

void clear(CycleList &list) {
	while (!isEmpty(list))
		remove(list, 0);
}