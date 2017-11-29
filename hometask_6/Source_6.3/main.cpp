#include <iostream>
#include <fstream>
#include "phonebook.h"
#include "files.h"

using namespace std;

int main() {
	PhoneBook myBook;
	int number = 0;

	ifstream in("Text.txt");
	int size = 0;
	in >> size;
	for (int i = 0; i < size; ++i) {
		char *name;
		name = inputName(in);
		number = inputNumber(in);
		add(name, number, myBook);
	}
	in.close();

	ofstream out("Text.txt");
	cout << "0 - exit" << endl << "1 - add an entry (name and phone number)" << endl << "2 - find number bu name" <<
		endl << "3 - find name by number" << endl << "4 - save the current data to a file" << endl;

	cout << endl << "Enter your command to phonebook: " << endl;
	int command = 0;
	cin >> command;
	while (command != 0) {
		char *name;
		switch (command) {
		case 1:
			name = inputName();
			number = inputNumber();
			add(name, number, myBook);
			break;

		case 2:
			name = inputName();
			cout << getNumber(name, myBook) << endl;
			break;

		case 3:
			number = inputNumber();
			cout << getName(number, myBook) << endl;
			break;

		case 4:
			save(out, myBook);
			break;
		}
		cout << "Enter your command to phonebook: " << endl;
		cin >> command;
	}

	out.close();
	clear(myBook);

	return 0;
}