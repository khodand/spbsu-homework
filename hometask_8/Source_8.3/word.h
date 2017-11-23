#pragma once
#include "String.h"

struct wordInfo {
	String text;
	int number;
};

wordInfo *create(String text);
void deleteWord(wordInfo  *word);