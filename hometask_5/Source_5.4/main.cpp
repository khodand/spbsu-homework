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
		if (curChar == 9 || curChar == ' ')
			continue;

		isFilled += (curChar >= 0 && curChar < 256 && curChar != '\t');

		if (curChar == '\t') {
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