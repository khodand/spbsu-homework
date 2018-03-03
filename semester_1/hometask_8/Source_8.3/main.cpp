#include <iostream>
#include <fstream>
#include "hashTab.h"

using namespace std;

int main() {
	HashMap map;

	ifstream in("Text.txt");
	while (!in.eof()) {
		String list;
		input(list, in);
		if (list.size != 0)
			add(list, map);
	}
	in.close();

	out(map);
	cout << "Number of words: " << endl;
	cout << numberOfWords(map) << endl;
	cout << "Average lenght of chain: " << endl;
	cout << getAverageLen(map);

	clear(map);
	return 0;
}
