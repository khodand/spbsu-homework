#include "spiral.h"
#include <iostream>

using namespace std;

void matrixBySpiral(int **matrix, int size) {
	const int startIndex = size / 2;
	cout << matrix[startIndex][startIndex] << ' ';

	int leftBorder = startIndex;
	int upBorder = startIndex - 1;
	int rightBorder = startIndex;
	int downBorder = startIndex;

	int i = leftBorder;
	int j = upBorder;

	while (j >= 0) {
		while (i <= rightBorder) {
			cout << matrix[j][i] << ' ';
			++i;
		}
		++rightBorder;

		while (j <= downBorder) 
			cout << matrix[j++][i] << ' ';
		++downBorder;

		while (i >= leftBorder)
			cout << matrix[j][i--] << ' ';
		--leftBorder;

		while (j >= upBorder)
			cout << matrix[j--][i] << ' ';
		--upBorder;
	}
}