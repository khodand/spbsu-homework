#include <iostream>
#include <math.h>
#include <iomanip>

using namespace std;

int const unsigned byteSize = 8;
int const unsigned doubleSize = 64;
int const unsigned numOfBytes = 8;
int const unsigned exponentAddition = 1023;
int const unsigned exponentSize = 11;
int const unsigned mantissaSize = 52;
int const unsigned maxPrecision = 100;

int exponention(int number, int exponent) {
	if (exponent == 0)
		return 1;
	if (exponent % 2 == 0)
		return exponention(number * number, exponent / 2);
	return number * exponention(number, exponent - 1);
}

int* getBinaryCode(double &number) {
	int *code = new int[doubleSize];
	int mask = 0x80;
	char unsigned*bytes = (char unsigned*)&number;

	for (int i = numOfBytes - 1; i >= 0; --i) 	{
		mask = 0x80;
		for (int j = 0; j < byteSize; ++j) 		{
			if (mask & bytes[i])
				code[(numOfBytes - i - 1) * byteSize + j] = 1;
			else
				code[(numOfBytes - i - 1) * byteSize + j] = 0;
			mask >>= 1;
		}
	}

	return code;
}

int getExponent(int *binaryCode) {
	int offsetExponent = 0;
	for (int i = 0; i < exponentSize; ++i) 	{
		offsetExponent += binaryCode[1 + i] * exponention(2, exponentSize - i - 1);
	}
	return offsetExponent - exponentAddition;
}

double getMantissa(int *binaryCode) {
	double mantissa = 1;
	for (int i = 1; i <= mantissaSize; ++i) 	{
		mantissa += binaryCode[11 + i] * pow(2, -i);
	}
	return mantissa;
}

int main() {
	double number = 0;
	cout << "Enter a number: " << endl;
	cin >> number;

	int *binaryCode = getBinaryCode(number);

	int exponent = getExponent(binaryCode);
	double mantissa = getMantissa(binaryCode);

	cout << "Number in E-notation: " << endl;
	if (binaryCode[0] != 0)
		cout << '-';

	cout << setprecision(maxPrecision) << mantissa << "*2^(" << exponent << ')';
	
	delete[] binaryCode;
	return 0;
}