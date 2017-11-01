#include <iostream>
#include "myString.h"
#include "qsort.h"

using namespace std;


int main() {

	int firstStrLen = 0;
	int secondStrLen = 0;


	cout << "Enter length of the first string: " << endl;
	cin >> firstStrLen;

	char* firstStr = new char[firstStrLen];
	inputStr(firstStr, firstStrLen);

	cout << "Enter length of the second string: " << endl;
	cin >> secondStrLen;

	char* secondStr = new char[secondStrLen];
	inputStr(secondStr, secondStrLen);


	if (firstStrLen == secondStrLen) {

		qsort(firstStr, 0, firstStrLen - 1);
		qsort(secondStr, 0, secondStrLen - 1);

		if (isEqual(firstStr, secondStr, firstStrLen))
			cout << "Possible" << endl;
		else
			cout << "Impossible" << endl;
	}
	else
		cout << "Impossible" << endl;


	delete[] firstStr;
	delete[] secondStr;
	return 0;
}