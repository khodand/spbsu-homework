#include "pair.h"
#include <string>
#include <iostream>

using namespace std;

Node *create(Node node) {
	Node *newNode = new Node;
	newNode->token = node.token;
	newNode->weight = node.weight;
	newNode->left = node.left;
	newNode->right = node.right;

	return newNode;
}

void out(Node *p) {
	if (p == nullptr)
		return;
	out(p->left);
	cout << p->token.first << endl;
	out(p->right);
}

void abcOut(Node *p) {
	cout << " (";
	if (p->left == nullptr && p->right == nullptr)
		cout << "\'" << p->token.first << "\'";
	else {
		cout << p->weight;
		abcOut(p->left);
		cout << "";
		abcOut(p->right);
	}
	cout << ")";
}

void abcOut(Node *p, std::ofstream &out) {
	out << " (";
	if (p->left == nullptr && p->right == nullptr)
		out << "\'" << p->token.first << "\'";
	else {
		out << p->weight;
		abcOut(p->left, out);
		out << "";
		abcOut(p->right, out);
	}
	out << ")";
}

void clear(Node *p) {
	if (p == nullptr)
		return;

	clear(p->left);
	clear(p->right);
	delete p;
	p = nullptr;
}
