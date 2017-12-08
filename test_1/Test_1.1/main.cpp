#include <iostream>
#include <fstream>

using namespace std;

int const alphabetSize = 256;

int main() {
	ofstream fout("Text.txt", ios::app);
	fout << "$";
	fout.close();

	ifstream in("Text.txt");
	int *frequensy = new int[alphabetSize];
	for (int i = 0; i < alphabetSize; ++i)
		frequensy[i] = 0;

	char curSymbol = ' ';
	in.get(curSymbol);
	while (curSymbol != '$') {
		frequensy[curSymbol]++;
		in.get(curSymbol);
	}
	in.close();

	ofstream out("output.txt");
	for (int i = 'a'; i <= 'z'; ++i) {
		if (frequensy[i] != 0)
			out << (char)i << " -- " << frequensy[i] << endl;
	}
	out.close();

	return 0;
}