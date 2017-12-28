#include <iostream>
#include "rabin.h"

using namespace std;

int main() {
	String inStr;
	String toFind;

	cout << "Enter your data and string to find in: " << endl;
	input(inStr);
	input(toFind);

	cout << "Indices of the occurrences of a substring: " << endl;
	outSubstrIndex(inStr, toFind);

	clear(inStr);
	clear(toFind);
	return 0;
}
