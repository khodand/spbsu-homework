#pragma once

struct listEl {
	int value;
	listEl *next;
};

struct cList {
	listEl *top;
	listEl *last;
	int size;
};

void createCList(cList &A);
void clear(cList &A);

void push(int value, cList &A);
void remove(cList &A, int i);

int get(cList &A, int i);

void out(cList &A, char end = '\n');