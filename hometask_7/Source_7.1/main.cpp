#include <iostream>
#include "bst.h"

using namespace std;

int main() {
	searchTree A;

	int input[10] = { 10, 12, 2, 1, 4, 3, 9, 7, 6, 8 };
	for (int i = 0; i < 10; ++i) {
		add(input[i], A);
	}

	abcOut(A);
	remove(10, A);
	abcOut(A);

	increasOut(A);
	decreasOut(A);

	return 0;
}