#include <iostream>

using namespace std;


int mypow(int a, int n) 
{
	if (n == 0)
		return 1;

	if (n % 2 == 1)
		return mypow(a, n - 1) * a;
	else 
	{
		int b = mypow(a, n / 2);
		return b * b;
	}
}


int main()
{
	int a = 0;
	int n = 0;

	cout << "Enter a and n: " << endl;
	cin >> a >> n;

	cout << "a^n = " << mypow(a, n);

	return 0;
}
