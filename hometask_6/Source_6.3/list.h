#pragma once
#include "person.h"

struct listEl {
	person *account;
	listEl *next;
};

struct list {
	listEl *first = nullptr;
	listEl *last = nullptr;
	int size = 0;
};

void add(person *account, list &A);

person get(int i, list &A);
void remove(int i, list &A);

bool isEmpty(list &A);

void clear(list &A);