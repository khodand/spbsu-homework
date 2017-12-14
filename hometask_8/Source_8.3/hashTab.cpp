#include "hashTab.h"

const int primeArrSize = 15;
const int primeArr[primeArrSize] = { 141, 4713, 5795, 6611, 18496, 32292, 32469, 59656, 90825,
							262419, 361275, 481899, 1354828, 6328548, 6679881 };

const int primeMultiplier = 79;

int setSize(int size) {
	for (int i = 0; i < primeArrSize; ++i) {
		if (size < primeArr[i])
			return primeArr[i];
	}
	return size;
}

void resize(hashMap &map) {
	hashMap newMap;
	newMap.size = setSize(map.size);
	newMap.hashes = new list[newMap.size];

	for (int i = 0; i < map.size; ++i)
		for (int j = 0; j < map.hashes[i].size; ++j)
			add(get(j, map.hashes[i]).text, newMap);

	clear(map);
	map = newMap;
}

int hash(String text, int size) { 
	int result = 0;

	result += text.data[text.size - 1];

	int p = primeMultiplier;
	for (int i = text.size - 2; i >= 0; --i) {
		result = (result + (text.data[i] * p) % size) % size;
		p *= p;
		p %= size;
	}

	return result;
}

void add(String text, hashMap &map) {
	if (map.size == 0) {
		map.size = primeArr[0];
		map.hashes = new list[map.size];
	}

	map.used++;

	double loadFactor = (double)map.used / map.size;
	if (loadFactor > 1)
		resize(map);

	wordInfo *newWord = create(text);
	int textHash = hash(text, map.size);
	add(newWord, map.hashes[textHash]);
}

int getFrequencyOfWord(String text, hashMap &map) {
	return getFrequencyOfWord(text, map.hashes[hash(text, map.size)]);
}

int numberOfWords(hashMap &map) {
	int result = 0;
	for (int i = 0; i < map.size; ++i) {
		result += numberOfWords(map.hashes[i]);
	}
	return result;
}

int numberOfEmptyBuckets(hashMap &map) {
	return map.size - map.used;
}

double getLoadFactor(hashMap &map) {
	return (double)map.used / map.size;
}

double getAverageLen(hashMap &map) {
	double sum = 0.0;
	for (int i = 0; i < map.size; ++i)
		sum += map.hashes[i].size;
	
	return sum / map.size;
}

int getMaxLen(hashMap &map) {
	int maxLen = 0;
	for (int i = 0; i < map.size; ++i)
		maxLen < map.hashes[i].size ? maxLen = map.hashes[i].size : maxLen = maxLen;

	return maxLen;
}

void outWholeChain(String text, hashMap &map) {
	int wordHash = hash(text, map.size);
	for (int i = 0; i < map.hashes[wordHash].size; ++i)
		output(get(i, map.hashes[wordHash]).text);
}

void clear(hashMap &map) {
	for (int i = 0; i < map.size; ++i)
		if (!isEmpty(map.hashes[i]))
			clear(map.hashes[i]);
	delete[] map.hashes;
}

void out(hashMap &map) {
	for (int i = 0; i < map.size; ++i)
		for (int j = 0; j < map.hashes[i].size; ++j)
			output(get(j, map.hashes[i]).text);
}