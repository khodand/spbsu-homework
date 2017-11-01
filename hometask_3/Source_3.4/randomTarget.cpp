#include "randomTarget.h"
#include <iostream>
#include <random> 

bool isInArr(char x, char* target, int len);

//the sequence of numbers from 0 to 9
char* createTarget(int len) {
	std::random_device rd;
	std::mt19937 gen(rd());

	char* target = new char[len] {'+'};

	for (int i = 0; i < len; ++i) {
		target[i] = '0' + (gen() % 10);
		if (isInArr(target[i], target, i))
			i--;
	}

	return target;
}

bool isInArr(char x, char* target, int len) {
	for (int i = 0; i < len; ++i)
		if (x == target[i])
			return true;

	return false;
}