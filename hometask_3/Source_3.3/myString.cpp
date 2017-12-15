#include "myString.h"
#include <iostream>

void inputStr(char *str, int len) {

	std::cout << "Enter the string: " << std::endl;

	for (int i = 0; i < len; ++i)
		std::cin >> str[i];
}

void outStr(char *str, int len) {

	std::cout << "The string: " << std::endl;

	for (int i = 0; i < len; ++i)
		std::cout << str[i] << " ";
	std::cout << std::endl;
}

bool isEqual(char *str1, char *str2, int len) {

	bool isEqual = true;
	for (int i = 0; i < len; ++i)
		if (str1[i] != str2[i]) {
			isEqual = false;
			break;
		}

	return isEqual;
}