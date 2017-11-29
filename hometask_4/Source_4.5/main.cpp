#include <iostream>
#include "postfixNotation.h"
#include "stack.h"
#include "queue.h"

using namespace std;

int main() {
	Queue inStr;
	createQueue(inStr);

	cout << "Enter a expression" << endl << "Don't forget to put '=' at the end!!!" << endl;

	char curToken = ' ';
	cin >> curToken;
	while (curToken != '=') {
		push(inStr, curToken);
		cin >> curToken;
	}

	cout << calculate(inStr) << endl;
	return 0;
}