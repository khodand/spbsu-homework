#include <iostream>
#include <fstream>
#include "list.h"

using namespace std;

int main() {
	List numbers;

	ifstream in("Text.txt");
	int number = 0;
	while (in >> number)
		add(numbers, number);
	in.close();

	if (isSymmetric(numbers))
		cout << "Your sequence is symmetric";
	else
		cout << "Your sequence is asymmetric";

	clear(numbers);
	return 0;
}