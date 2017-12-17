#include "list.h"

ListElement *create(Person *account) {
	ListElement *newElement = new ListElement;
	newElement->account = account;
	newElement->next = nullptr;

	return newElement;
}

void add(Person *account, List &list) {
	if (isEmpty(list)) {
		list.first = create(account);
		list.last = list.first;
	}
	else {
		list.last->next = create(account);
		list.last = list.last->next;
	}

	list.size++;
}

Person get(int i, List &list) {
	ListElement *temp = list.first;
	while (i > 0) {
		temp = temp->next;
		--i;
	}

	return *temp->account;
}

void remove(int i, List &list) {
	if (i == 0) {
		deletePerson(list.first->account);
		list.first = list.first->next;
	}
	else {
		ListElement *temp = list.first;
		while (i > 1) {
			temp = temp->next;
			--i;
		}

		deletePerson(temp->next->account);
		temp->next = temp->next->next;
	}
	list.size--;
}

bool isEmpty(List &list) {
	return list.first == nullptr;
}

void clear(List &list) {
	while (!isEmpty(list))
		remove(0, list);
}