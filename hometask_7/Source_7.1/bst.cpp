#include "bst.h"
#include <iostream>

node *createNode(int value) {
	node *newNode = new node;

	newNode->value = value;
	newNode->left = nullptr;
	newNode->right = nullptr;
	
	return newNode;
}

bool isEmpty(searchTree &A) {
	return A.root == nullptr;
}

//  left < root <= right
void push(int value, node *&p) {
	if (p == nullptr) {
		p = createNode(value);
		return;
	}
	if (value < p->value)
		push(value, p->left);
	else
		push(value, p->right);
}

void add(int value, searchTree &A) {
	push(value, A.root);
}

// the left subtree into root
void deleteNode(node *&p) {
	node *newRoot = p->left;

	if (p->right != nullptr) {
		node *rightEnd = p->right;
		while (rightEnd->left != nullptr)
			rightEnd = rightEnd->left;

		rightEnd->left = newRoot->right;
		newRoot->right = p->right;
		p = newRoot;
	}
	else 
		p = newRoot;
}

void remove(int value, node *&p) {
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
void remove(int value, searchTree &A) {
	remove(value, A.root);
}

void outByLevel(node *p) {
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

void abcOut(searchTree &A) {
	outByLevel(A.root);
	std::cout << std::endl;
}

bool isContains(int value, node *p) {
	if (p == nullptr)
		return false;

	if (p->value == value)
		return true;

	if (value < p->value)
		return isContains(value, p->left);
	else
		return isContains(value, p->right);
}

bool isContains(int value, searchTree &A) {
	return isContains(value, A.root);
}

void incOut(node *p) {
	if (p == nullptr)
		return;

	incOut(p->left);
	std::cout << " " << p->value << " ";
	incOut(p->right);
}

void increasOut(searchTree &A) {
	incOut(A.root);
	std::cout << std::endl;
}

void decOut(node *p) {
	if (p == nullptr)
		return;

	decOut(p->right);
	std::cout << " " << p->value << " ";
	decOut(p->left);
}

void decreasOut(searchTree &A) {
	decOut(A.root);
	std::cout << std::endl;
}