#include <iostream>
#include <cmath>

using namespace std;

int main()
{
	int n = 0;

	cout << "Enter n: " << endl;
	cin >> n;

	++n;

	bool* isChecked = new bool[n] {false};
	
	int limit = sqrt(n);
	for (int i = 2; i < limit; ++i) 
	{
		for (int j = 2 * i; j < n; j += i) 
		{
			isChecked[j] = true;
		}
	}

	cout << "Primes <= n:" << endl;
	for (int i = 2; i < n; ++i)
		if (!isChecked[i])
			cout << i << " ";

	delete[] isChecked;
	return 0;
}