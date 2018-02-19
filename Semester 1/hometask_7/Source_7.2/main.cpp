#include <iostream>
#include "avlTree.h"

using namespace std;

int main() {
	AvlTree tree;

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
			add(value, tree);
			break;

		case 2:
			cout << "Input value to remove:" << endl;
			cin >> value;
			remove(value, tree);
			break;

		case 3:
			cout << "Input value to check:" << endl;
			cin >> value;
			if (isContains(value, tree))
				cout << "True" << endl;
			else
				cout << "False" << endl;
			break;

		case 4:
			decreasOut(tree);
			break;

		case 5:
			increasOut(tree);
			break;

		case 6:
			abcOut(tree);
			break;
		}
		cout << "Enter your command to binary search tree: " << endl;
		cin >> command;
	}

	clear(tree);
	return 0;
}