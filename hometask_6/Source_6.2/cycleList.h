#pragma once

struct ListElement {
	int value;
	ListElement *next;
};

struct CycleList {
	ListElement *top = nullptr;
	ListElement *last = nullptr;
	int size = 0;
};

void clear(CycleList &list);

void push(int value, CycleList &list);
void remove(CycleList &list, int i);

int get(CycleList &list, int i);
int getSize(CycleList &list);

void killEveryK(CycleList &list, int k);
void out(CycleList &list, char end = '\n');