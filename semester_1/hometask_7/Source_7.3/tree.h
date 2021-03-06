#pragma once
#include <iostream>
#include <fstream>

struct Operand {
	char token;

	Operand *left = nullptr;
	Operand *right = nullptr;
};

struct OperandTree {
	Operand *root;
};

void fillSubTree(Operand *&p, std::ifstream &in); 
int countSubTree(Operand *p);

void abcOut(Operand *p);

void clear(Operand *p);