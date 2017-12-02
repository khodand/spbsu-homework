#pragma once
#include <string>
#include <fstream>

struct Pair {
	char first;
	int second = 0;
};

struct Node {
	int weight = 0;
	Pair token;
	Node *left = nullptr;
	Node *right = nullptr;
};

Node *create(Node pair);
void clear(Node *p);

void out(Node *p);
void abcOut(Node *p);
void abcOut(Node *p, std::ofstream &cout);