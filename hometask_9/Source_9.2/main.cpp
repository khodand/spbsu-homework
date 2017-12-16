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

	encode(in, out);

	in.close();
	out.close();
	return 0;
}
