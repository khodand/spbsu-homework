#pragma once
#include "person.h"

struct ListElement {
	Person *account;
	ListElement *next;
};

struct List {
	ListElement *first = nullptr;
	ListElement *last = nullptr;
	int size = 0;
};

void add(Person *account, List &list);

Person get(int i, List &list);
void remove(int i, List &list);

bool isEmpty(List &list);

void clear(List &list);