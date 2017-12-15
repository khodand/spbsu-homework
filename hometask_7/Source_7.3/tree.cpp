#include "tree.h"

char getNextToken(std::ifstream &in) {
	char result = ' ';
	in.get(result);
	while (result == ' ')
		in.get(result);

	return result;
}

bool isDigit(char token) {
	return token >= '0' && token <= '9';
}

void fillSubTree(Operand *&p, std::ifstream &in) {
	p = new Operand;

	getNextToken(in); // readed '('

	p->token = getNextToken(in);
	if (!isDigit(p->token)) {
		fillSubTree(p->left, in);
		fillSubTree(p->right, in);
	}

	getNextToken(in); // readed ')'
}


int countSubTree(Operand *p) {
	if (p == nullptr)
		return 0;
	if (isDigit(p->token))
		return p->token - '0';

	switch (p->token) {
	case '+':
		return countSubTree(p->left) + countSubTree(p->right);
	case '-':
		return countSubTree(p->left) - countSubTree(p->right);
	case '*':
		return countSubTree(p->left) * countSubTree(p->right);
	case '/':
		return countSubTree(p->left) / countSubTree(p->right);
	}

	return 0;
}

void clear(Operand *p) {
	if (p == nullptr)
		return;

	clear(p->left);
	clear(p->right);
	delete p;
}