#include "huffmanEncode.h"

bool codeToSymbol(Node *p, std::ifstream &in, std::ofstream &out) {
	if (p->token.first != 0) {
		out << p->token.first;
		return true;
	}
	char curSymbol = ' ';
	in.get(curSymbol);
	if (curSymbol == '1')
		return codeToSymbol(p->right, in, out);
	if (curSymbol == '0')
		return codeToSymbol(p->left, in, out);
	return false;
}

char getNextToken(std::ifstream &in) {
	char result = ' ';
	in.get(result);
	while (result == ' ')
		in.get(result);

	return result;
}

void skipManyTokens(std::ifstream &in) {
	char result = ' ';
	in.get(result);
	while (result != ' ')
		in.get(result);
}

Node* fillTreeFromABC(std::ifstream &in) {
	Node *newNode = new Node;

	getNextToken(in); // readed '('

	if (getNextToken(in) == '\'') {
		in.get(newNode->token.first);
		getNextToken(in); // readed '\''
	}
	else {
		skipManyTokens(in);
		newNode->left = fillTreeFromABC(in);
		newNode->right = fillTreeFromABC(in);
	}

	getNextToken(in); // readed ')'
	return newNode;
}

void decode(Node *root, std::ifstream &in, std::ofstream &out) {
	out << "Decoded message: " << std::endl;
	getNextToken(in);
	while (codeToSymbol(root, in, out));
	out << std::endl;
}