#include <iostream>
#include "qsort.h"
#include "myString.h"

using namespace std;


int main() {
	
	int number;

	cout << "Enter your number: " << endl;
	cin >> number;

	int *digits = new int[30];
	digits[0] = number % 10;

	int numberOfDigits = 1;
	while (number / 10 != 0) {
		number /= 10;
		digits[numberOfDigits] = number % 10;
		numberOfDigits++;
	}

	qsort(digits, 0, numberOfDigits - 1);

	cout << "Min from such digits: ";
	for (int i = 0; i < numberOfDigits; ++i)
		cout << digits[i];
	cout << endl;

	delete[] digits;
	return 0;
}