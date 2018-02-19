#include <iostream>

using namespace std;


long long recursion(int n)
{
	if (n == 1)
		return 1;
	return n * recursion(n - 1);
}


long long iterative(int n)
{
	long long result = 1;
	for (int i = 2; i <= n; ++i)
		result *= i;
	return result;
}


int main()
{
	int n = 0;
	int method = 0;

	cout << "Enter n: " << endl;
	cin >> n;
	cout << "Recursive? (0)" << endl << "iterative? (1)" << endl << "Enter number of method: " << endl;
	cin >> method;

	if (method)
		cout << iterative(n);
	else
		cout << recursion(n);

	return 0;
}
