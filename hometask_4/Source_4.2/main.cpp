#include <iostream>
#include <fstream>
#include "queue.h"

using namespace std;

int unsigned const alphabetSize = 256;

int main() {
	ifstream cin("text.txt");
	bool *isLetterIn = new bool[alphabetSize]{ false };

	Queue queue;
	char curChar = ' ';
	while (!cin.eof()) {
		cin.get(curChar);

		if (curChar == ' ') {
			delete[] isLetterIn;
			isLetterIn = new bool[alphabetSize]{ false };
			push(queue, curChar);
			continue;
		}

		if (!isLetterIn[curChar]) {
			push(queue, curChar);
			isLetterIn[curChar] = true;
		}
	}

	cin.close();

	while (!isEmpty(queue))
		cout << (char)pop(queue);

	delete[] isLetterIn;
	return 0;
}