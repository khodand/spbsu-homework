#include <iostream>

using namespace std;

int main()
{
	int len = 0;
	int i = 0;

	cout << "Enter string's length: " << endl;
	cin >> len;

	char* str = new char[len];
	cout << "Enter string: " << endl;
	for (int i = 0; i < len; ++i)
		cin >> str[i];

	int isOdd = len % 2;

	for (i = 0; i < len / 2; ++i)
		if (str[len / 2 - 1 - i] != str[len / 2 + i + isOdd])
		{
			cout << "Not a palindrome";
			break;
		}

	if (i == len / 2)
		cout << "Palindrome";

	delete[] str;

	return 0;
}