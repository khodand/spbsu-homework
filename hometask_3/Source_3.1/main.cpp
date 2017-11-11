#include <iostream>
#include "qsort.h"

using namespace std;

int main() {

	int len = 0;

	cout << "Enter array's length: " << endl;
	cin >> len;

	int *numbers = new int[len];

	cout << "Enter array: " << endl;
	for (int i = 0; i < len; ++i)
		cin >> numbers[i];

	qsort(numbers, 0, len - 1);

	int maxSearcher = len - 1;
	while (maxSearcher >= 0 && numbers[maxSearcher] != numbers[maxSearcher - 1])
		maxSearcher--;

	if (maxSearcher == 0)
		cout << endl << "There is no max element of an array that occur more than once.";
	else
		cout << endl << "Max element of an array that occur more than once: " << numbers[maxSearcher];

	delete[] numbers;
	return 0;
}
