#pragma once

struct node {
	int value;
	node *left;
	node *right;
};
//  left < root <= right
struct searchTree {
	node *root = nullptr;
};

void add(int value, searchTree &A);
void remove(int value, searchTree &A);

bool isContains(int value, searchTree &A);
bool isEmpty(searchTree &A);

void increasOut(searchTree &A);
void decreasOut(searchTree &A);
void abcOut(searchTree &A);