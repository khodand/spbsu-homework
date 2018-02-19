#include <iostream>

using namespace std;

int main() 
{
	int x = 0; 

	cout << "Enter x: " << endl;
	cin >> x;

	int x2 = x * x;

	cout << "x^4 + x^3 + x^2 + x + 1 = "<< (x2 + x) * (x2 + 1) + 1 << endl;

	return 0;
}