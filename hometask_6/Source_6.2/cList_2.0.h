#pragma once
#include <iostream>

struct ListElement {
	int value;
	ListElement *next = nullptr;
	ListElement *prev = nullptr;
};

struct CycleList {
	ListElement *current = nullptr;
	int size = 0;
};

void push(int value, CycleList &list);
void remove(CycleList &list, int i);

int get(CycleList &list, int i);
int getSize(CycleList &list);

bool isEmpty(CycleList list);

void out(CycleList &list, int add = 0);

void clear(CycleList &list);
