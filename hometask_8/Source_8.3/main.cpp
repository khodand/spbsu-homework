#include <iostream>
#include <fstream>
#include "hashTab.h"

using namespace std;

int main() {
	hashMap map;

	ofstream fout("Text.txt", ios::app);
	fout << "$";
	fout.close();

	ifstream in("Text.txt");
	bool isEnd = false;
	while (!isEnd) {
		String A;
		isEnd = input(A, in);
		if (A.size != 0)
			add(A, map);
	}
	in.close();

	out(map);
	cout << "Number of words: " << endl;
	cout << numberOfWords(map) << endl;
	cout << "Average lenght of chain: " << endl;
	cout << getAverageLen(map);

	return 0;
}
