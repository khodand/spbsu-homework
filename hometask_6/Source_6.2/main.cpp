#include <iostream>
#include "cycleList.h"

using namespace std;

int main() {
	CycleList warriorsCircle;

	int number = 0;
	int killingIndex = 0;
	cout << "Enter number of warriors and killing index:" << endl;
	cin >> number >> killingIndex;

	for (int i = number - 1; i >= 0; --i)
		push(i, warriorsCircle);

	killEveryK(warriorsCircle, killingIndex - 1);

	cout << "Joseph should stay on position with number: ";
	out(warriorsCircle);

	clear(warriorsCircle);
	return 0;
}