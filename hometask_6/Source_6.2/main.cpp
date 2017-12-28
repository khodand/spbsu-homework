#include <iostream>
#include "Clist_2.0.h"

using namespace std;

int main() {
	CycleList warriorsCircle;

	int number = 0;
	int killingIndex = 0;
	cout << "Enter number of warriors and killing index:" << endl;
	cin >> number >> killingIndex;

	for (int i = 0; i < number; ++i)
		push(i, warriorsCircle);

	get(warriorsCircle, 1);
	out(warriorsCircle, 1);

	while (warriorsCircle.size != 1) {
		remove(warriorsCircle, killingIndex - 1);
		out(warriorsCircle, 1);
	}

	cout << "Joseph should stay on position with number: ";
	out(warriorsCircle, 1);

	clear(warriorsCircle);
	return 0;
}