#include <iostream>

using namespace std;

int iterativeFibonacci(int n)
{
	int result = 1;
	int prev1 = 1;
	int prev2 = 1; // 1, 1, 2, ... prev2, prev1, result...

	for (int i = 2; i < n; ++i) 
	{
		result = prev1 + prev2; 
		prev2 = prev1;
		prev1 = result;
	}

	return result;
}


int recursiveFibonacci(int n)
{
	if (n == 2 || n == 1)
		return 1;
	return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
}


int main()
{
	int n = 0;
	cout << "Enter the number of Fibonacci number: " << endl;
	cin >> n;
	
	cout << n << "Fibonacci number is calculated recursively and iteratively:" << endl << recursiveFibo(n) << endl << iterativeFibo(n);

	return 0;
}