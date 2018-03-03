#pragma once
#include "list.h"

struct HashMap {
	List *hashes;
	
	int used = 0;
	int size = 0;
};

void add(String text, HashMap &A);

int getFrequencyOfWord(String text, HashMap &A);

double getAverageLen(HashMap &A);
int getMaxLen(HashMap &A);

void outWholeChain(String word, HashMap &A);

int numberOfWords(HashMap &A);
int numberOfEmptyBuckets(HashMap &A);
double getLoadFactor(HashMap &A);

void out(HashMap &A);
void clear(HashMap &A);

