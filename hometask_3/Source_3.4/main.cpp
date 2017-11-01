#include <iostream>
#include "randomTarget.h"

using namespace std;


int countBulls(char *target, char *guess, int len) {
	int bulls = 0;
	for (int i = 0; i < len; ++i)
		if (target[i] == guess[i])
			bulls++;
	return bulls;
}

int countCows(char *target, char *guess, int len) {
	int cows = 0;
	for (int i = 0; i < len; ++i)
		for (int j = 0; j < len; ++j)
			if (target[i] == guess[j])
				cows++;
	return cows;
}

int main() {
	
	const int len = 4;

	char guess[len];
	int turn = 1;

	char *target = createTarget(len);
	for (int i = 0; i < len; ++i)
		cout << target[i];
	cout << endl;

	cout << "Enter your guess:" << endl;
	while (true) {
		int bulls = 0;
		int cows = 0;

		cout << turn++ << "       ";

		for (int i = 0; i < len; ++i)
			cin >> guess[i];

		bulls = countBulls(target, guess, len);
		cows = countCows(target, guess, len);

		cout << "Result: " << bulls << "Bulls " << cows - bulls << "Cows" << endl;

		if (bulls == 4)
			break;
	}
	
	cout << "You won!!!"<< endl;

	delete[] target;
	return 0;
}