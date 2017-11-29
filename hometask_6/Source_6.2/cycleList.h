#pragma once

struct ListEl {
	int value;
	ListEl *next;
};

struct CycleList {
	ListEl *top;
	ListEl *last;
	int size;
};

void createCycleList(CycleList &A);
void clear(CycleList &A);

void push(int value, CycleList &A);
void remove(CycleList &A, int i);

int get(CycleList &A, int i);
int getSize(CycleList &A);

void out(CycleList &A, char end = '\n');