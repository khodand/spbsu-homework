#pragma once
#include "list.h"

struct hashMap {
	list *hashes;
	
	int used = 0;
	int size = 0;
};

void add(String text, hashMap &A);

int getFrequencyOfWord(String text, hashMap &A);

double getAverageLen(hashMap &A);
int getMaxLen(hashMap &A);

void outWholeChain(String word, hashMap &A);

int numberOfWords(hashMap &A);
int numberOfEmptyBuckets(hashMap &A);
double getLoadFactor(hashMap &A);

void out(hashMap &A);
void clear(hashMap &A);

