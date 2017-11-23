#pragma once
#include <iostream>
#include <fstream>

struct String
{
	char *data;
	int size = 0;
};

bool areEqual(String &string1, String &string2);

bool input(String &string, std::ifstream &cin);

void input(String &string);
void output(String &string);

String clone(String &string);

void cont(String &string, String &addition);
// [first, last)
String getSubstring(String &string, int first, int last);

void clear(String &string);

char *getCharArray(String &string);