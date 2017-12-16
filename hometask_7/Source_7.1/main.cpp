#include <iostream>
#include "bst.h"

using namespace std;

enum commands {EXIT, INPUT, REMOVE, CONTAINS, DECREAS, INCREAS, ABCPRINT };

istream& operator>>(istream &in, commands &command) {
	int tmp;
	if (in >> tmp)
		command = static_cast<commands>(tmp);
	return in;
}


int main() {
	SearchTree bst;

	cout << "0 - exit" << endl << "1 - add value" << endl << "2 - remove value" << endl <<
		"3 - check whether element is" << endl << "4 - print in decreasing order" << endl << 
		"5 - print in increasing order" << endl << "6 - print in ABC order";

	cout << endl << "Enter your command to binary search tree: " << endl;
	commands command = EXIT;
	cin >> command;
	while (command != EXIT) {
		int value = 0;
		switch (command) {
		case INPUT:
			cout << "Input value to add:" << endl;
			cin >> value;
			add(value, bst);
			break;

		case REMOVE:
			cout << "Input value to remove:" << endl;
			cin >> value;
			remove(value, bst);
			break;

		case CONTAINS:
			cout << "Input value to check:" << endl;
			cin >> value;
			if (isContained(value, bst))
				cout << "True" << endl;
			else
				cout << "False" << endl;
			break;

		case DECREAS:
			decreasOut(bst);
			break;

		case INCREAS:
			increasOut(bst);
			break;

		case ABCPRINT:
			abcOut(bst);
			break;
		}
		cout << "Enter your command to binary search tree: " << endl;
		cin >> command;
	}

	clear(bst);
	return 0;
}