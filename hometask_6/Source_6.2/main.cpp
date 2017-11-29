#include <iostream>
#include "cycleList.h"

using namespace std;

int main() {	
	CycleList warriorsCircle;
	createCycleList(warriorsCircle);
	
	int number = 0;
	int killingIndex = 0;
	cout << "Enter number of warriors and killing index:" << endl;
	cin >> number >> killingIndex;

	for (int i = number - 1; i >= 0; --i)
		push(i, warriorsCircle);

	int toKill = killingIndex;
	while (warriorsCircle.size > 1) {
		remove(warriorsCircle, toKill - 1);
		toKill = (toKill + killingIndex - 1) % getSize(warriorsCircle);
	}

	cout << "Joseph should stay on position with number : ";
	out(warriorsCircle);

	clear(warriorsCircle);
	return 0;
}