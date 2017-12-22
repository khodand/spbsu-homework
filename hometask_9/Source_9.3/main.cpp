#include <iostream>
#include <fstream>
#include "huffmanEncode.h"

using namespace std;

int main() {
	ifstream in("input.txt");
	ofstream out("output.txt");

	Node *huffmanTreeRoot = fillTreeFromABC(in);
	decode(huffmanTreeRoot, in, out);
	clear(huffmanTreeRoot);

	in.close();
	out.close();

	return 0;
}