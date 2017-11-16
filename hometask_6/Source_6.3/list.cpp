#include "list.h"

listEl *create(person *account) {
	listEl *newEl = new listEl;
	newEl->account = account;
	newEl->next = nullptr;

	return newEl;
}

void add(person *account, list &A) {
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

person get(int i, list &A) {
	listEl *temp = A.first;
	while (i > 0) {
		temp = temp->next;
		--i;
	}

	return *temp->account;
}

void remove(int i, list &A) {
	if (i == 0) {
		deletePerson(A.first->account);
		A.first = A.first->next;
	}
	else {
		listEl *temp = A.first;
		while (i > 1) {
			temp = temp->next;
			--i;
		}

		deletePerson(temp->next->account);
		temp->next = temp->next->next;
	}
	A.size--;
}

bool isEmpty(list &A) {
	return A.first == nullptr;
}

void clear(list &A) {
	while (!isEmpty(A))
		remove(0, A);
}