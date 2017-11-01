#include <iostream>

using namespace std;

void decompose(int n, int currentNumber, int relevantElements, int *terms)
{
	if (n >= 0) {
		if (n == 0) {
			for (int j = 0; j < relevantElements; j++)
				cout << terms[j] << " ";
			cout << endl;
		}
		else
		{
			if (n - currentNumber >= 0)
			{
				terms[relevantElements] = currentNumber;
				decompose(n - currentNumber, currentNumber, relevantElements + 1, terms);
			}

			if (currentNumber - 1 > 0) 
				decompose(n, currentNumber - 1, relevantElements, terms);
		}
	}
}

int main() {
	int n = 0;

	cout << "Enter terms number: " << endl;
	cin >> n;

	int *terms = new int[n];

	for (int i = 0; i <= n; i++) 
		terms[i] = 0;

	cout << "Each possible decomposition: " << endl;
	decompose(n, n, 0, terms);

	delete[] terms;	
	return 0;
}