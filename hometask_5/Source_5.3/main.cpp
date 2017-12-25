#include <iostream>
#include "polinom.h"

using namespace std;

int unsigned const maxSize = 10000;
int unsigned const maxDegree = 100;

int main() {
	int coefficients[maxDegree];
	char upperRow[maxSize]{' '};
	char lowerRow[maxSize]{' '};

	int degree = 0;
	cout << "Enter degree of your polynomial: " << endl;
	cin >> degree;
	degree++;

	cout << "Enter coefficients of your polynomial: " << endl;
	for (int i = 0; i < degree; ++i)
		cin >> coefficients[i];
	
	int size = beautify(coefficients, upperRow, lowerRow, degree);

	cout << "Your polynomial is written KPACUBO: " << endl;
	for (int i = 0; i < size; ++i)
		cout << upperRow[i];
	cout << endl;
	for (int i = 0; i < size; ++i)
		cout << lowerRow[i];

	return 0;
}