#include "hashTab.h"

const int primeArrSize = 15;
const int primeArr[primeArrSize] = { 141, 4713, 5795, 6611, 18496, 32292, 32469, 59656, 90825,
							262419, 361275, 481899, 1354828, 6328548, 6679881 };

const int primeMultiplier = 101;

int setSize(int size) {
	for (int i = 0; i < primeArrSize; ++i) {
		if (size < primeArr[i])
			return primeArr[i];
	}
	return size;
}

void resize(hashMap &A) {
	hashMap newMap;
	newMap.size = setSize(A.size);
	newMap.hashes = new list[newMap.size];

	for (int i = 0; i < A.size; ++i)
		for (int j = 0; j < A.hashes[i].size; ++j)
			add(get(j, A.hashes[i]).text, newMap);

	clear(A);
	A = newMap;
}

int hash(String text, int size) { 
	int result = 0;

	result += text.data[text.size - 1];

	int p = primeMultiplier;
	for (int i = text.size - 2; i >= 0; --i) {
		result = (result + text.data[i] * (p % size)) % size;
		p *= p;
	}

	return result;
}

void add(String text, hashMap &A) {
	if (A.size == 0) {
		A.size = primeArr[0];
		A.hashes = new list[A.size];
	}

	A.used++;

	double loadFactor = (double)A.used / A.size;
	if (loadFactor > 1)
		resize(A);

	wordInfo *newWord = create(text);
	add(newWord, A.hashes[hash(text, A.size)]);
}

int getFrequencyOfWord(String text, hashMap &A) {
	return getFrequencyOfWord(text, A.hashes[hash(text, A.size)]);
}

int numberOfWords(hashMap &A) {
	int result = 0;
	for (int i = 0; i < A.size; ++i) {
		result += numberOfWords(A.hashes[i]);
	}
	return result;
}

int numberOfEmptyBuckets(hashMap &A) {
	return A.size - A.used;
}

double getLoadFactor(hashMap &A) {
	return (double)A.used / A.size;
}

double getAverageLen(hashMap &A) {
	double sum = 0.0;
	for (int i = 0; i < A.size; ++i)
		sum += A.hashes[i].size;
	
	return sum / A.size;
}

int getMaxLen(hashMap &A) {
	int maxLen = 0;
	for (int i = 0; i < A.size; ++i)
		maxLen < A.hashes[i].size ? maxLen = A.hashes[i].size : maxLen = maxLen;

	return maxLen;
}

void outWholeChain(String text, hashMap &A) {
	int wordHash = hash(text, A.size);
	for (int i = 0; i < A.hashes[wordHash].size; ++i)
		output(get(i, A.hashes[wordHash]).text);
}

void clear(hashMap &A) {
	for (int i = 0; i < A.size; ++i) {
		clear(A.hashes[i]);
		delete[] A.hashes;
	}
}

void out(hashMap &A) {
	for (int i = 0; i < A.size; ++i)
		for (int j = 0; j < A.hashes[i].size; ++j)
			output(get(j, A.hashes[i]).text);
}