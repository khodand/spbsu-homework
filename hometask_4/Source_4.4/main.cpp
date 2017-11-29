#include <iostream>
#include "postfixNotation.h"
#include "stack.h"
#include "queue.h"

using namespace std;

int main() {
	Queue inStr;
	createQueue(inStr);

	cout << "Enter an expression in postfix notation" << endl << "Don't forget to put '=' at the end!!!" << endl;

	char curToken = ' ';
	cin >> curToken;
	while (curToken != '=') {
		push(inStr, curToken);
		cin >> curToken;
	}

	cout << calculate(inStr, true) << endl;

	return 0;
}