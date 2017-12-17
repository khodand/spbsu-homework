#include "String.h"

const int maxSize = 10000;

bool input(String &string, std::ifstream &cin) {
	char tmp[maxSize];
	char curSymbol = ' ';

	int size = 0;
	cin.get(curSymbol);
	while (curSymbol != '\n' && curSymbol != ' ' && !cin.eof()) {
		tmp[size] = curSymbol;
		size++;
		cin.get(curSymbol);
	}

	string.data = new char[size];
	string.size = size;
	for (int i = 0; i < size; ++i)
		string.data[i] = tmp[i];

	return cin.eof();
}

void input(String &string) {
	char tmp[maxSize];
	char curSymbol = 0;

	int size = 0;
	std::cin.get(curSymbol);
	while (curSymbol != '\n' && curSymbol != ' ') 	{
		tmp[size] = curSymbol;
		size++;
		std::cin.get(curSymbol);
	}

	string.data = new char[size];
	string.size = size;
	for (int i = 0; i < size; ++i)
		string.data[i] = tmp[i];
}

void output(String string) {
	for (int i = 0; i < string.size; i++)
		std::cout << string.data[i];
	std::cout << std::endl;
}

bool areEqual(String &string1, String &string2) {
	if (string1.size != string2.size)
		return false;

	for (int i = 0; i < string1.size; ++i) {
		if (string1.data[i] != string2.data[i])
			return false;
	}
	return true;
}

String clone(String &string) {
	String newString;
	newString.size = string.size;

	newString.data = new char[newString.size];
	for (int i = 0; i < newString.size; i++) 
		newString.data[i] = string.data[i];

	return newString;
}

void cont(String &string, String &addition) {
	int newSize = string.size + addition.size;
	char *newData = new char[newSize];

	for (int i = 0; i < string.size; ++i)
		newData[i] = string.data[i];

	for (int i = string.size; i < newSize; ++i)
		newData[i] = addition.data[i - string.size];

	delete[] string.data;
	string.size = newSize;
	string.data = newData;
}

char* getCharArray(String &string) {
	return string.data;
}

// [first, last)
String getSubstring(String &string, int first, int last) {
	String result;
	if (last > string.size || first >= last)
		return result;

	int newSize = last - first;
	char* subData = new char[newSize];

	for (int i = first; i < last; ++i)
		subData[i - first] = string.data[i];

	result.data = subData;
	result.size = newSize;

	return result;
}

void clear(String &string) {
	delete[] string.data;
	string.size = 0;
}