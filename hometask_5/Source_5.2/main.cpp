#include <iostream>

using namespace std;

void outInBin(int value) {
	int temp = 1;
	int digitsNum = 1;
	bool sign = true;

	if (value < 0) {
		value *= -1;
		sign = false;
	}

	while ((temp << digitsNum++) <= value);

	bool *binValue = new bool[--digitsNum];
	for (int i = 0; i < digitsNum; ++i) {
		binValue[i] = value & 1;
		value = value >> 1;
	}

	if (!sign)
		cout << '-';
	for (int i = digitsNum - 1; i >= 0; --i)
		cout << binValue[i];
	cout << endl;
}

int main() {
	int term1 = 0;
	int term2 = 0;

	cout << "Enter first and second terms: " << endl;
	cin >> term1 >> term2;

	cout << "First term: ";
	outInBin(term1);
	cout << "Second term: ";
	outInBin(term2);

	int sum = term1 + term2;
	cout << "Sum in binary notation:";
	outInBin(sum);
	cout << "Sum in decimal notation:" << sum << endl;

	system("pause");
	return 0;
}