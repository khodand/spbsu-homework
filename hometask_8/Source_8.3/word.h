#pragma once
#include "String.h"

struct WordInfo {
	String text;
	int number;
};

WordInfo *create(String text);
void deleteWord(WordInfo  *word);