#include <iostream>
#include "stack.h"

using namespace std;

void outBinary(const int unsigned x) {
	int unsigned bit = 0x800000;
	while (bit) {
		if (x & bit)
			cout << "1";
		else
			cout << "0";

		bit >>= 1;
	}
	cout << endl;
}

void binSum(const int unsigned a, const int unsigned b) {
	Stack answer;
	int unsigned bit = 1;
	int addition = 0;
	while (bit <= 0x800000) {
		int bitA = 0;
		int bitB = 0;
		bit & a ? bitA = 1 : bitA = 0;
		bit & b ? bitB = 1 : bitB = 0;

		int bitSum = addition + bitA + bitB;
		switch (bitSum) {
		case 0:
			push(answer, 0);
			break;
		case 1:
			push(answer, 1);
			addition = 0;
			break;
		case 2:
			push(answer, 0);
			addition = 1;
			break;
		case 3:
			push(answer, 1);
			addition = 1;
			break;
		}
		bit <<= 1;
	}

	if (isEmpty(answer))
		cout << 0;
	while (!isEmpty(answer))
		cout << pop(answer);

	cout << endl;
}

int main() {
	int first = 0;
	int second = 0;

	cout << "Write two numbers: " << endl;
	cin >> first >> second;

	int unsigned absFirst = first;
	int unsigned absSecond = second;

	cout << "Numbers in binary: " << endl;
	outBinary(absFirst);
	outBinary(absSecond);

	cout << "Sum in binary: " << endl;
	int unsigned sum = absFirst + absSecond;
	binSum(absFirst, absSecond);

	cout << "Decimal sum: " << endl;
	bool bit = (sum & 0x80000000);
	int decimalSum = (bit ? (~sum) + 1 : sum);
	if (bit)
		cout << "-";
	cout << decimalSum;

	return 0;
}