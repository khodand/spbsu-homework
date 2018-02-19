#include <iostream>
#include <fstream>

using namespace std;

int unsigned const stopCounter = 100;

int main() {
	ifstream in("Text.txt");
	
	int counter = 0; // if a file ends, the last character is entered an infinite number of times
	char curToken = ' ';
	char prevToken = ' ';

	while (counter < stopCounter) {
		in.get(curToken);
		if (curToken == ';') {
			while (curToken != '\n') {
				cout << curToken;
				in.get(curToken);
			}
			cout << endl;
		}

		if (curToken == prevToken)
			counter++;
		else
			counter = 0;

		prevToken = curToken;
	}

	in.close();

	return 0;
}