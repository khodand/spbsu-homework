#include <iostream>

using namespace std;

int unsigned const maxSize = 120;

enum States { firstLetterState, followingSymbolsState, error };

bool isDigit(char symbol) {
	return symbol >= '0' && symbol <= '9';
}

bool isLetter(char symbol) {
	return (symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z');
}

States nextState(States curState, char symbol) {
	switch (curState) {
	case firstLetterState:
		if (isLetter(symbol))
			return followingSymbolsState;
		return error;

	case followingSymbolsState:
		if (isDigit(symbol) || isLetter(symbol) || symbol == '_')
			return followingSymbolsState;
		return error;

	default:
		return error;
	}
}

bool isCorrectString(char *input) {
	int i = 0;
	States curState = firstLetterState;
	while (input[i] != ' ') {
		curState = nextState(curState, input[i++]);
		if (curState == error)
			return false;
	}

	return input[0] != ' ' && (curState == firstLetterState || curState == followingSymbolsState);
}

int main() {
	char input[maxSize];
	cout << "Enter your string: " << endl;
	
	char curSymbol = ' ';
	cin.get(curSymbol);
	int i = 0;
	while (curSymbol != ' ' && curSymbol != '\n') {
		input[i++] = curSymbol;
		cin.get(curSymbol);
	}
	input[i] = ' ';


	if (isCorrectString(input))
		cout << "Correct string";
	else
		cout << "Incorrect string";

	return 0;
}