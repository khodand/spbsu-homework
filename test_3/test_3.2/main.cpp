#include <iostream>
#include <fstream>
#include "points.h"

using namespace std;

void resize(int *&arr, int &size) {
	int newSize = size * 2;
	int *resizedArr = new int[newSize];
	for (int i = 0; i < size; ++i) {
		resizedArr[i] = arr[i];
	}

	delete[] arr;

	size = newSize;
	arr = resizedArr;
}

int main() {
	int n = 0;
	int m = 0;
	
	ifstream in("Text.txt");

	cout << "Enter size of your matrix (M x N):" << endl;
	in >> m >> n;

	int **numbers = new int*[m];
	for (int i = 0; i < m; ++i)
		numbers[i] = new int[n];

	cout << "Enter your matrix: " << endl;
	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < n; ++j) {
			in >> numbers[i][j];
		}
	}
	in.close();

	outPoints(numbers, m, n);

	for (int i = 0; i < m; ++i)
		delete[] numbers[i];
	delete[] numbers;
	return 0;
}