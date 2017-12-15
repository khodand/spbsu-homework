#include <iostream>

using namespace std;

int unsigned const maxSize = 10 * 1000;

int enterValue(bool *number) {
	char curToken = ' ';
	int size = 0;

	cin.get(curToken);
	while (curToken != ' ' && curToken != '\n') {
		number[size++] = (bool)(curToken - '0');
		cin.get(curToken);
	}

	return size;
}

int main() {
	bool firstNumber[maxSize];
	bool secondNumber[maxSize];

	cout << "Enter your numbers: " << endl;
	int firstNumberSize = enterValue(firstNumber);
	int secondNumberSize = enterValue(secondNumber);

	if (firstNumberSize > secondNumberSize)
		cout << "first > second";
	else {
		if (firstNumberSize < secondNumberSize)
			cout << "second > first";
		else {
			for (int i = 0; i < firstNumberSize; ++i) {
				if (firstNumber[i] != secondNumber[i]) {
					if (firstNumber[i])
						cout << "first > second";
					else
						cout << "second > first";
				}
			}
		}
	}
	
	cout << endl << "if there was no text => numbers are equal";

	return 0;
}