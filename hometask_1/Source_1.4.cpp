#include <iostream>

using namespace std;

int main()
{
	const int numOfSums = 27;
	const int digitsNum = 10;

	int sums[numOfSums] = { 0 };
	int numb = 1;

	for (int i = 0; i < digitsNum; ++i)
		for (int j = 0; j < digitsNum; ++j)
			for (int k = 0; k < digitsNum; ++k)
				sums[i + j + k]++;

	for (int i = 0; i < numOfSums; ++i)
		numb += sums[i] * sums[i];

	cout << "Number of lucky tickets = " << numb << endl;

	delete[] sums;

	return 0;
}
