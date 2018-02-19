#include <iostream>
#include "String.h"

using namespace std;

int main() {
	String A;
	String B;

	cout << "Enter first string: " << endl;
	input(A);
	cout << "Enter second string: " << endl;
	input(B);

	cout << "Your first string: " << endl;
	output(A);
	cout << "Your second string: " << endl;
	output(B);

	cont(A, B);

	cout << "Result of first + second: " << endl;
	output(A);

	int first = 0;
	int last = 0;
	cout << "Enter number of first and last element:" << endl;
	cin >> first >> last;

	cout << "Your substring:" << endl;
	String out = getSubstring(A, first, last);
	output(out);

	clear(A);
	clear(B);
	clear(out);
	return 0;
}