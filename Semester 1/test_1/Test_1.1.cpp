#include <iostream>

using namespace std;

int main()
{
	int len = 0;
	bool isCorrect = true;

	cout << "Enter string's length: " << endl;
	cin >> len;

	char *str = new char[len];

	int currentPosition = 0;
	int possibleIterations = 0;
	cout << "Enter string: " << endl;
	while (possibleIterations < len)
	{
		possibleIterations++;
		char curSymbol = ' ';
		cin >> curSymbol;

		if ((curSymbol >= 'a' && curSymbol <= 'z') || (curSymbol >= 'A' && curSymbol <= 'Z') || curSymbol == ' ')
			continue;
		if (curSymbol == '[' || curSymbol == '{' || curSymbol == '(')
			str[currentPosition++] = curSymbol;
		else
		{
			if (currentPosition == 0)
			{
				isCorrect = false;
				break;
			}
			if (curSymbol == ']' && str[currentPosition - 1] != '[')
			{
				isCorrect = false;
				break;
			}
			if (curSymbol == '}' && str[currentPosition - 1] != '{')
			{
				isCorrect = false;
				break;
			}
			if (curSymbol == ')' && str[currentPosition - 1] != '(')
			{
				isCorrect = false;
				break;
			}
			--currentPosition;
		}
	}
	if (isCorrect && currentPosition == 0)
		cout << "This is the correct string";
	else
		cout << "This is the incorrect string";

	delete[] str;
	return 0;
}