#include <iostream>
#include <fstream>
#include "huffmanEncode.h"

using namespace std;

int main() {
	ofstream end("input.txt", ios::app);
	end << '$';
	end.close();

	ifstream in("input.txt");
	ofstream out("output.txt");

	Node *huffmanTreeRoot = encode(in, out);

	in.close();
	out.close();

	in.open("output.txt");
	out.open("input.txt", ios::app);

	out << endl;
	decode(huffmanTreeRoot, in, out);

	in.close();
	out.close();

	return 0;
}