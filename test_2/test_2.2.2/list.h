#pragma once

struct Node {
	int value;

	Node *next = nullptr;
	Node *prev = nullptr;
};

struct List {
	int size = 0;
	Node *head = nullptr;
	Node *tail = nullptr;
};

void add(List &list, int value);
void clear(List &list);

bool isEmpty(List list);
bool isSymmetric(List list);