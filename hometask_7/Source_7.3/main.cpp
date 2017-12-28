#include <iostream>
#include <fstream>
#include "tree.h"

using namespace std;

int main() {
	OperandTree tree;

	ifstream in("Text.txt");
	fillSubTree(tree.root, in);
	in.close();

	abcOut(tree.root);
	cout << endl << "Result of your expression: " << countSubTree(tree.root);
	
	clear(tree.root);
	return 0;
}