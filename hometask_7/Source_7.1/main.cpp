#include <iostream>
#include "bst.h"

using namespace std;

enum Commands {quit, input, erase, contains, decreasPrint, increasPrint, abcPrint };

istream& operator>>(istream &in, Commands &command) {
	int tmp;
	if (in >> tmp)
		command = static_cast<Commands>(tmp);
	return in;
}


int main() {
	SearchTree bst;

	cout << "0 - exit" << endl << "1 - add value" << endl << "2 - remove value" << endl <<
		"3 - check whether element is" << endl << "4 - print in decreasing order" << endl << 
		"5 - print in increasing order" << endl << "6 - print in ABC order";

	cout << endl << "Enter your command to binary search tree: " << endl;
	Commands command = quit;
	cin >> command;
	while (command != quit) {
		int value = 0;
		switch (command) {
		case input:
			cout << "Input value to add:" << endl;
			cin >> value;
			add(value, bst);
			break;

		case erase:
			cout << "Input value to remove:" << endl;
			cin >> value;
			remove(value, bst);
			break;

		case contains:
			cout << "Input value to check:" << endl;
			cin >> value;
			if (isContained(value, bst))
				cout << "True" << endl;
			else
				cout << "False" << endl;
			break;

		case decreasPrint:
			decreasOut(bst);
			break;

		case increasPrint:
			increasOut(bst);
			break;

		case abcPrint:
			abcOut(bst);
			break;
		}
		cout << "Enter your command to binary search tree: " << endl;
		cin >> command;
	}

	clear(bst);
	return 0;
}
