#include <iostream>
#include <fstream>

using namespace std;

int main() {
	ifstream cin("text.txt");

	char curChar;

	bool isFilled = false;
	int filledStrings = 0;
	while (!cin.eof()) {
		cin.get(curChar);
		if (curChar == '\t' || curChar == ' ')
			continue;

		isFilled += (curChar >= 0 && curChar < 256 && curChar != '\n');

		if (curChar == '\n') {
			if (isFilled)
				filledStrings++;
			isFilled = false;
		}
	}
	cin.close();

	if (isFilled)
		filledStrings++;

	cout << filledStrings << endl;

	return 0;
}
