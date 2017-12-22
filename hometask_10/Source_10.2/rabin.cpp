#include "rabin.h"
#include <iostream>

using namespace std;

int const primeMultiplier = 255;
int const limit = 10 * 1000 * 1000 + 19;

bool isEqualSubstring(String text, String substr, int from) {
	for (int i = 0; i < substr.size; ++i) {
		if (text.data[from + i] != substr.data[i])
			return false;
	}
	return true;
}

// [from, to)
int toHash(String str, int from, int to) {
	int result = str.data[to - 1];

	int p = primeMultiplier;
	for (int i = to - 2; i >= from; --i) {
		result = (result + str.data[i] * (p % limit)) % limit;
		p *= p;
	}

	return result;
}

void outSubstrIndex(String input, String substr) {
	int subHash = toHash(substr, 0, substr.size);
	int hashToCheck = 0;

	int endIndex = input.size - substr.size + 1; 
	for (int i = 0; i < endIndex; ++i) {
		hashToCheck = toHash(input, i, i + substr.size);

		if (subHash == hashToCheck)
			if (isEqualSubstring(input, substr, i))
				cout << i << " ";
	}
	cout << endl;
}