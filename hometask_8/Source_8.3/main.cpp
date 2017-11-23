#include <iostream>
#include "hashTab.h"
#include <fstream>

using namespace std;

int main() {
	String A;
	String B;
	hashMap map;

	ofstream fout("Text.txt", ios::app);
	fout << "$";
	fout.close();

	ifstream in("Text.txt");
	bool isEnd = false;
	while (!isEnd) {
		isEnd = input(A, in);
		if (A.size != 0)
			add(A, map);
	}
	in.close();

	out(map);
	cout << numberOfWords(map);
	cout << " ";
	cout << getAverageLen(map);
	cout << endl;

	return 0;
}