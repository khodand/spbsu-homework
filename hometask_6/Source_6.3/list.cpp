#include "list.h"

ListEl *create(Person *account) {
	ListEl *newEl = new ListEl;
	newEl->account = account;
	newEl->next = nullptr;

	return newEl;
}

void add(Person *account, List &A) {
	if (isEmpty(A)) {
		A.first = create(account);
		A.last = A.first;
	}
	else {
		A.last->next = create(account);
		A.last = A.last->next;
	}

	A.size++;
}

Person get(int i, List &A) {
	ListEl *temp = A.first;
	while (i > 0) {
		temp = temp->next;
		--i;
	}

	return *temp->account;
}

void remove(int i, List &A) {
	if (i == 0) {
		deletePerson(A.first->account);
		A.first = A.first->next;
	}
	else {
		ListEl *temp = A.first;
		while (i > 1) {
			temp = temp->next;
			--i;
		}

		deletePerson(temp->next->account);
		temp->next = temp->next->next;
	}
	A.size--;
}

bool isEmpty(List &A) {
	return A.first == nullptr;
}

void clear(List &A) {
	while (!isEmpty(A))
		remove(0, A);
}