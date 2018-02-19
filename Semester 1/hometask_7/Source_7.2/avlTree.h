#pragma once

struct Node {
	int key;

	int height = 0;
	Node *left = nullptr;
	Node *right = nullptr;
};

struct AvlTree {
	Node *root = nullptr;
};

void add(int value, AvlTree &tree);
void remove(int value, AvlTree &tree);

bool isContains(int value, AvlTree &tree);
bool isEmpty(AvlTree &tree);

void increasOut(AvlTree &tree);
void decreasOut(AvlTree &tree);
void abcOut(AvlTree &tree);

void clear(AvlTree &tree);