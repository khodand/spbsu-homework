#include <iostream>
#include "cycleList.h"

using namespace std;

int main() {	
	cList A;
	createCList(A);
	
	int number = 0;
	int killingIndex = 0;
	cout << "Enter number of warriors and killing index:" << endl;
	cin >> number >> killingIndex;

	for (int i = number - 1; i >= 0; --i)
		push(i, A);

	int toKill = killingIndex;
	while (A.size > 1) {
		remove(A, toKill - 1);
		toKill = (toKill + killingIndex - 1) % A.size;
	}

	cout << "Joseph should stay on position with number : ";
	out(A);

	clear(A);
	return 0;
}