#include "huffmanEncode.h"

using namespace std;

void sortNodeArr(Node *arr, int size) {
	for (int i = 1; i < size; ++i)
		for (int j = i; j > 0 && arr[j - 1].weight < arr[j].weight; --j) {
			Node temp = arr[j - 1];
			arr[j - 1] = arr[j];
			arr[j] = temp;
		}
}

void reweigh(Node *node) {
	node->weight = 0;

	if (node->left != nullptr) {
		reweigh(node->left);
		node->weight += node->left->weight;
	}
	if (node->right != nullptr) {
		reweigh(node->right);
		node->weight += node->right->weight;
	}
	node->weight += node->token.second;
}

void fillMap(string code, Node *p, string *map) {
	if (p->token.second != 0) {
		map[p->token.first] = code;
		return;
	}
	fillMap(code + "1", p->right, map);
	fillMap(code + "0", p->left, map);
}

void setTextAndFrequensy(string &input, Node *arr, ifstream &in) {
	char symbol = ' ';
	in.get(symbol);
	while (symbol != '$') {
		input += symbol;

		arr[symbol % alphabetLen].token.first = symbol;
		arr[symbol % alphabetLen].token.second++;
		arr[symbol % alphabetLen].left = nullptr;
		arr[symbol % alphabetLen].right = nullptr;
		reweigh(&arr[symbol % alphabetLen]);

		in.get(symbol);
	}
}

void frequencyTableToConsole(Node *arr) {
	cout << "Frequency table: " << endl;
	for (int i = 0; i < alphabetLen; ++i) {
		if (arr[i].token.second != 0)
			cout << "\'" << (char)i << "\' - " << arr[i].token.second << endl;
	}
}

void dictionaryToConsole(string *map) {
	cout << "Symbols and their codes: " << endl;
	for (int i = 0; i < alphabetLen; ++i) {
		if (map[i] != "")
			cout << "\'" << (char)i << "\' - " << map[i] << endl;
	}
}

Node makeTreeFromFreqArr(Node *arr, int size) {
	while (size != 1) {
		arr[size - 2].left = create(arr[size - 2]);
		arr[size - 2].right = create(arr[size - 1]);
		arr[size - 2].token.first = 0;
		arr[size - 2].token.second = 0;

		reweigh(&arr[size - 2]);
		size--;
		sortNodeArr(arr, size);
	}

	return arr[0];
}

Node* encode(ifstream &in, ofstream &out) {
	Node charFrequensy[alphabetLen];
	string input = "";
	setTextAndFrequensy(input, charFrequensy, in);

	frequencyTableToConsole(charFrequensy);

	int arrLen = 0;
	sortNodeArr(charFrequensy, alphabetLen);
	while (charFrequensy[arrLen++].token.second != 0);
	arrLen--;
	
	Node huffmanTreeRoot = makeTreeFromFreqArr(charFrequensy, arrLen);

	string map[alphabetLen];
	for (int i = 0; i < alphabetLen; ++i)
		map[i] = "";
	fillMap("", &huffmanTreeRoot, map);

	dictionaryToConsole(map);

	for (int i = 0; i < input.size(); ++i)
		out << map[input[i]];
	out << endl;

	return &huffmanTreeRoot;
}

bool codeToSymbol(Node *p, ifstream &in, ofstream &out) {
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

void decode(Node *root, ifstream &in, ofstream &out) {
	out << "Decoded message: " << endl;
	while (codeToSymbol(root, in, out));
	out << endl;
}