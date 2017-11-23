#pragma once
#include "word.h"

struct listEl {
	wordInfo *word;
	listEl *next;
};

struct list {
	listEl *first = nullptr;
	listEl *last = nullptr;
	int size = 0;
};

void add(wordInfo *word, list &A);

wordInfo get(int i, list &A);
void setNumber(int i, list &A, int number);
void remove(int i, list &A);

int getFrequencyOfWord(String text, list &A);
int numberOfWords(list &A);
bool isEmpty(list &A);

void clear(list &A);