#include "bst.h"
#include <iostream>

Node *createNode(int value) {
	Node *newNode = new Node;

	newNode->value = value;
	newNode->left = nullptr;
	newNode->right = nullptr;
	
	return newNode;
}

bool isEmpty(SearchTree &A) {
	return A.root == nullptr;
}

//  left < root <= right
void push(int value, Node *&p) {
	if (p == nullptr) {
		p = createNode(value);
		return;
	}
	if (value < p->value)
		push(value, p->left);
	else
		push(value, p->right);
}

void add(int value, SearchTree &A) {
	push(value, A.root);
}

// the left subtree into root
void deleteNode(Node *&p) {
	Node *newRoot = p->left;

	if (p->right != nullptr) {
		Node *rightEnd = p->right;
		while (rightEnd->left != nullptr)
			rightEnd = rightEnd->left;

		rightEnd->left = newRoot->right;
		newRoot->right = p->right;
		delete p;
		p = newRoot;
	}
	else {
		delete p;
		p = newRoot;
	}
}

void remove(int value, Node *&p) {
	if (p == nullptr)
		return;

	if (value < p->value)
		remove(value, p->left);
	else
		remove(value, p->right);

	if (p->value == value)
		deleteNode(p);
}

// Removes all items with such key
void remove(int value, SearchTree &A) {
	remove(value, A.root);
}

void outByLevel(Node *p) {
	if (p != nullptr) {
		std::cout << " (" << p->value;
		outByLevel(p->left);
		std::cout << "";
		outByLevel(p->right);
		std::cout << ")";
	}
	else
		std::cout << " NULL";
}

void abcOut(SearchTree &A) {
	outByLevel(A.root);
	std::cout << std::endl;
}

bool isContained(int value, Node *p) {
	if (p == nullptr)
		return false;

	if (p->value == value)
		return true;

	if (value < p->value)
		return isContained(value, p->left);
	else
		return isContained(value, p->right);
}

bool isContained(int value, SearchTree &A) {
	return isContained(value, A.root);
}

void incOut(Node *p) {
	if (p == nullptr)
		return;

	incOut(p->left);
	std::cout << " " << p->value << " ";
	incOut(p->right);
}

void increasOut(SearchTree &A) {
	incOut(A.root);
	std::cout << std::endl;
}

void decOut(Node *p) {
	if (p == nullptr)
		return;

	decOut(p->right);
	std::cout << " " << p->value << " ";
	decOut(p->left);
}

void decreasOut(SearchTree &A) {
	decOut(A.root);
	std::cout << std::endl;
}

void clear(Node *p) {
	if (p == nullptr)
		return;

	clear(p->left);
	clear(p->right);
	delete p;
}
void clear(SearchTree &A) {
	clear(A.root);
}