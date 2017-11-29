#include <iostream>
#include "bst.h"

using namespace std;

int main() {
	SearchTree bst;

	cout << "0 - exit" << endl << "1 - add value" << endl << "2 - remove value" << endl <<
		"3 - check whether element is" << endl << "4 - print in decreasing order" << endl << 
		"5 - print in increasing order" << endl << "6 - print in ABC order";

	cout << endl << "Enter your command to binary search tree: " << endl;
	int command = 0;
	cin >> command;
	while (command != 0) {
		int value = 0;
		switch (command) {
		case 1:
			cout << "Input value to add:" << endl;
			cin >> value;
			add(value, bst);
			break;

		case 2:
			cout << "Input value to remove:" << endl;
			cin >> value;
			remove(value, bst);
			break;

		case 3:
			cout << "Input value to check:" << endl;
			cin >> value;
			if (isContains(value, bst))
				cout << "True" << endl;
			else
				cout << "False" << endl;
			break;

		case 4:
			decreasOut(bst);
			break;

		case 5:
			increasOut(bst);
			break;

		case 6:
			abcOut(bst);
			break;
		}
		cout << "Enter your command to binary search tree: " << endl;
		cin >> command;
	}

	clear(bst);
	return 0;
}