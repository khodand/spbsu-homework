#pragma once
#include "word.h"

struct ListElement {
	WordInfo *word = nullptr;
	ListElement *next = nullptr;
};

struct List {
	ListElement *first = nullptr;
	ListElement *last = nullptr;
	int size = 0;
};

void add(WordInfo *word, List &list);

WordInfo get(int i, List &list);
void setNumber(int i, List &list, int number);
void remove(int i, List &list);

int getFrequencyOfWord(String text, List &list);
int numberOfWords(List &list);
bool isEmpty(List &list);

void clear(List &list);