#include <iostream>

using namespace std;

void pushBack(int x, int *&arr, int curIndex, int &len) {

	if (curIndex >= len)
		len *= 2;

	int *resultArr = new int[len];

	for (int i = 0; i < curIndex; ++i)
		resultArr[i] = arr[i];

	resultArr[curIndex] = x;

	delete[] arr;
	arr = resultArr;
}

int fareySequence(int *&numerator, int *&denominator, int &len, int n) {
	int curIndex = 1;
	int newLen = 1;
	int *newNumerator = new int[newLen];
	int *newDenominator = new int[newLen];

	newNumerator[0] = 0;
	newDenominator[0] = 1;

	int lenChanges = 0;
	for (int i = 0; i < len - 1; ++i) {
		if (denominator[i] + denominator[i + 1] <= n) {
			pushBack(numerator[i] + numerator[i + 1], newNumerator, curIndex, newLen);
			pushBack(denominator[i] + denominator[i + 1], newDenominator, curIndex, newLen);
			curIndex++;

			pushBack(numerator[i + 1], newNumerator, curIndex, newLen);
			pushBack(denominator[i + 1], newDenominator, curIndex, newLen);
			curIndex++;

			lenChanges++;
		}
		else {
			pushBack(numerator[i + 1], newNumerator, curIndex, newLen);
			pushBack(denominator[i + 1], newDenominator, curIndex, newLen);
			curIndex++;
		}
	}

	len += lenChanges;

	delete[] numerator;
	delete[] denominator;

	numerator = newNumerator;
	denominator = newDenominator;

	return lenChanges;
}

int main()
{
	int n = 0;
	int len = 2;

	cout << "Enter n: " << endl;
	cin >> n;

	int *numerator = new int[len] { 0, 1 };
	int *denominator = new int[len] { 1, 1 };

	for (int i = 0; i < n; ++i)
		if (fareySequence(numerator, denominator, len, n) == 0)
			break;

	cout << "The sequence: " << endl;
	for (int i = 0; i < len; ++i)
		cout << numerator[i] << "/" << denominator[i] << " ";

	delete[] numerator;
	delete[] denominator;
	return 0;
}