#include <iostream>
#include "spiral.h"

using namespace std;

int main() {
	int n = 0;
	cout << "Enter n : ";
	cin >> n;

	int **matrix = new int*[n];
	for (int i = 0; i < n; ++i)
		matrix[i] = new int[n];

	cout << "Enter n x n matrix : " << endl;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j) 
			cin >> matrix[i][j];

	cout << "Entered matrix by spiral: " << endl;
	matrixBySpiral(matrix, n);

	for (int i = 0; i < n; ++i)
		delete[] matrix[i];
	delete[] matrix;
	return 0;
}