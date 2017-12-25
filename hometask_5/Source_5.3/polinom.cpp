#include "polinom.h"

int abs(int value) {
	return value > 0 ? value : -value;
}

int countDigits(int unsigned x) {
	int result = 0;
	while (x > 0) {
		x /= 10;
		++result;
	}
	return result;
}

void putToRow(char *row, int value, int &i) {
	value = abs(value);

	int size = countDigits(value);
	int lastIndex =  i + size - 1;
	while (value > 0) {
		row[lastIndex] = '0' + value % 10;
		value /= 10;
		--lastIndex;
	}
	i += size;
}

void putSign(char *row, char sign, int &i) {
	row[++i] = sign;
	i += 2;
}

int beautify(int *coefficients, char *upper, char *lower, int deg) {
	int rowIndex = 0;

	for (int i = 0; i < deg; ++i) {
		if (coefficients[i] == 0)
			continue;

		coefficients[i] > 0 ? putSign(lower, '+', rowIndex) : putSign(lower, '-', rowIndex);
		putToRow(lower, coefficients[i], rowIndex);

		int curDeg = deg - i - 1;
		if (curDeg > 0) {
			lower[rowIndex++] = 'x';
			putToRow(upper, curDeg, rowIndex);
		}
	}
	return rowIndex;
}