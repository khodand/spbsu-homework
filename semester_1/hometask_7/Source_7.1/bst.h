#pragma once

struct Node {
	int value;
	Node *left;
	Node *right;
};
//  left < root <= right
struct SearchTree {
	Node *root = nullptr;
};

void add(int value, SearchTree &A);
void remove(int value, SearchTree &A);

bool isContained(int value, SearchTree &A);
bool isEmpty(SearchTree &A);

void increasOut(SearchTree &A);
void decreasOut(SearchTree &A);
void abcOut(SearchTree &A);

void clear(SearchTree &A);