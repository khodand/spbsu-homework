#include <iostream>
#include <stdio.h>

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
	outBinary(sum);

	cout << "Decimal sum: " << endl;
	bool bit = (sum & 0x80000000);
	int decimalSum = (bit ? (~sum) + 1 : sum);
	if (bit)
		cout << "-";
	cout << decimalSum;

	return 0;
}