#include <iostream>

using namespace std;

void inputStr(char *str, int len)
{
	for (int i = 0; i < len; ++i)
	{
		cin >> str[i];
	}
}


int main()
{
	int len = 0;
	int len2 = 0;
	int subStrNum = 0;
	bool isSubStr = true;

	cout << "Enter the text's lenght: " << endl;
	cin >> len;

	char* str = new char[len];
	cout << "Enter the text: " << endl;
	inputStr(str, len);

	cout << "Enter the substring's lenght: " << endl;
	cin >> len2;

	char* subStr = new char[len2];
	cout << "Enter substring: " << endl;
	inputStr(subStr, len2);

	for (int i = 0; i < len - len2 + 1; ++i)
	{
		isSubStr = true;
		for (int j = 0; j < len2; ++j)
		{
			isSubStr = isSubStr && (str[i + j] == subStr[j]);
		}
		if (isSubStr)
			++subStrNum;
	}

	cout << "The number of substrings = " << subStrNum;

	delete[] str;
	delete[] subStr;
	return 0;
}