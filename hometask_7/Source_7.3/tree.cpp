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

	p->token = getNextToken(in); // readed '(' or digit

	if (!isDigit(p->token)) {
		p->token = getNextToken(in);
		fillSubTree(p->left, in);
		fillSubTree(p->right, in);

		getNextToken(in); // readed ')'
	}
}

void abcOut(Operand *p) {
	if (p != nullptr) {
		if (isDigit(p->token))
			std::cout << " " << p->token;
		else {
			std::cout << " (" << p->token;
			abcOut(p->left);
			abcOut(p->right);
			std::cout << ")";
		}
	}
	else
		std::cout << " NULL";
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