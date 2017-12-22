#include <iostream>
#include "rabin.h"

using namespace std;

int main() {
	String inStr;
	String toFind;

	cout << "Enter your data and string to find in: " << endl;
	input(inStr);
	input(toFind);

	cout << "Indices of the occurrences of a substring: " << endl;
	outSubstrIndex(inStr, toFind);

<<<<<<< HEAD
	clear(inStr);
	clear(toFind);
=======
>>>>>>> 030b7a5531d6bd86fdf9ccbc353efe332ca531d0
	return 0;
}
