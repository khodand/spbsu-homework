#include <iostream>

using namespace std;

int main()
{
	int len = 0;
	int i = 0;
	bool isCorrect = true;

	cout << "Enter string's length: " << endl;
	cin >> len;

	char *str = new char[len];

	cout << "Enter string: " << endl;
	while (i < len)
	{
		char curSymbol = ' ';
		cin >> curSymbol;

		if (curSymbol == '[' && curSymbol == '{' && curSymbol == '(')
			str[i++] = curSymbol;
		else
		{
			if (i == 0)
			{
				isCorrect = false;
				break;
			}
			if (curSymbol == ']' && str[i] != '[')
			{
				isCorrect = false;
				break;
			}
			if (curSymbol == '}' && str[i] != '{')
			{
				isCorrect = false;
				break;
			}
			if (curSymbol == ')' && str[i] != '(')
			{
				isCorrect = false;
				break;
			}
			--i;
		}
	}
	
	if (isCorrect && i == 0)
		cout << "This is the correct string";
	else
		cout << "This is the incorrect string";

	delete[] str;
	return 0;
}