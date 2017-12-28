#include <iostream>

using namespace std;

int unsigned const maxSize = 120;

enum States { initalState, intState, pointState, fractState, EState, expSignState, expState, error };

bool isDigit(char symbol) {
	return symbol >= '0' && symbol <= '9';
}

States nextState(States curState, char symbol) {
	switch (curState) {
	case initalState:
		if (isDigit(symbol))
			return intState;
		return error;

	case intState:
		if (isDigit(symbol))
			return intState;
		if (symbol == '.')
			return pointState;
		return error;

	case pointState:
		if (isDigit(symbol))
			return fractState;
		return error;

	case fractState: 
		if (isDigit(symbol))
			return fractState;
		if (symbol == 'E')
			return EState;
		return error;

	case EState:
		if (symbol == '+' || symbol == '-')
			return expSignState;
		return error;

	case expSignState:
		if (isDigit(symbol))
			return expState;
		return error;

	case expState:
		if (isDigit(symbol))
			return expState;
		return error;

	default:
		return error;
	}


}

bool isDouble(char *input) {
	int i = 0;
	States curState = initalState;
	while (input[i] != ' ') {
		curState = nextState(curState, input[i++]);
		if (curState == error)
			return false;
	}

	return curState == intState || curState == fractState || curState == expState;
}

int main() {
	char input[maxSize];
	cout << "Enter your number: " << endl;
	
	char curSymbol = ' ';
	cin.get(curSymbol);
	int i = 0;
	while (curSymbol != ' ' && curSymbol != '\n') {
		input[i++] = curSymbol;
		cin.get(curSymbol);
	}
	input[i] = ' ';

	if (isDouble(input))
		cout << "Correct";
	else
		cout << "Error!!!";

	return 0;
}