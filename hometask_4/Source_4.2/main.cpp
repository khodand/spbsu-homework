#include <iostream>
#include <fstream>
#include "queue.h"

using namespace std;

int main() {
	ifstream cin("text.txt");
	bool *isLetterIn = new bool[256]{ false };

	char curChar;

	Queue *tempQ = createQueue();
	Queue queue = *tempQ;
	delete[] tempQ;

	while (!cin.eof()) {
		cin.get(curChar);

		if (curChar == ' ') {
			delete[] isLetterIn;
			isLetterIn = new bool[256]{ false };
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
	system("pause");
	return 0;
}