#pragma once
#include "person.h"

struct ListEl {
	Person *account;
	ListEl *next;
};

struct List {
	ListEl *first = nullptr;
	ListEl *last = nullptr;
	int size = 0;
};

void add(Person *account, List &A);

Person get(int i, List &A);
void remove(int i, List &A);

bool isEmpty(List &A);

void clear(List &A);