#include <iostream>
#include <fstream>
#include "files.h"

using namespace std;

char *inputName(ifstream &cin) {
	char *name = new char[maxNameLenght] {' '};

	char curToken = ' ';
	int i = 0;
	cin >> curToken;
	while (curToken != ' ' && curToken != '\n') {
		name[i] = curToken;
		++i;
		cin.get(curToken);
	}

	return name;
}

char *inputName() {
	char *name = new char[maxNameLenght] {' '};

	cout << "Enter name:" << endl;
	char curToken = ' ';
	int i = 0;
	cin >> curToken;
	while (curToken != ' ' && curToken != '\n') {
		name[i] = curToken;
		++i;
		cin.get(curToken);
	}

	return name;
}

int inputNumber(ifstream &cin) {
	long int number = 0;
	cin >> number;

	return number;
}

int inputNumber() {
	long int number = 0;
	cout << "Enter number:" << endl;
	cin >> number;

	return number;
}
