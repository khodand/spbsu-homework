#include <iostream>

using namespace std;


int main()
{
	int a = 0;
	int b = 0;
	int result = 0;

	cout << "Enter a and b: " << endl;
	cin >> a >> b;

	int unsignA = abs(a);
	int unsignB = abs(b);

	while (unsignA >= unsignB)
	{
		unsignA -= unsignB;
		++result;
	}

	if (a * b < 0) 
		result *= -1;
	if (a < 0)
		--result;

	cout << "[a/b] = " << result;

	return 0;
}