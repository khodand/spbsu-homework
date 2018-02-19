#include <iostream>
#include "qsort.h"
//#include "myString.h"

using namespace std;


int main() {
	
	int number;

	cout << "Enter your number: " << endl;
	cin >> number;

	int digits[30];
	digits[0] = number % 10;

	int numberOfDigits = 1;
	while (number / 10 != 0) {
		number /= 10;
		digits[numberOfDigits] = number % 10;
		numberOfDigits++;
	}

	qsort(digits, 0, numberOfDigits - 1);

	cout << "Min from such digits: " << endl;
	
	int firstNonZero = 0;
	while (digits[firstNonZero++] == 0);
	cout << digits[--firstNonZero];

	for (int i = 0; i < firstNonZero; ++i)
			cout << digits[i];
	for (int i = firstNonZero + 1; i < numberOfDigits; ++i)
		cout << digits[i];

	return 0;
}
