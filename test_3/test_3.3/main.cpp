#include <iostream>
#include <fstream>
#include "queue.h"

using namespace std;

void bfs(int v, int **matrix, int size, Queue &nextV, bool *used) {
	cout << v << " ";
	used[v] = true;

	for (int i = 0; i < v; ++i)
		if (matrix[v][i] != 0 && !used[i])
			push(nextV, i);
	for (int i = v + 1; i < size; ++i)
		if (matrix[v][i] != 0 && !used[i])
			push(nextV, i);

	while (!isEmpty(nextV))
		bfs(pop(nextV), matrix, size, nextV, used);
}

int main() {
	ifstream in("input.txt");
	int size = 0;
	in >> size;

	bool *used = new bool[size];
	int **matrix = new int*[size];
	for (int i = 0; i < size; ++i) {
		used[i] = false;
		matrix[i] = new int[i] {0};
	}

	for (int i = 0; i < size; ++i)
		for (int j = 0; j < size; ++j)
			in >> matrix[i][j];
	in.close();

	Queue nextVertex;
	for (int i = 0; i < size; ++i)
		if (!used[i])
			bfs(i, matrix, size, nextVertex, used);

	delete[] used;
	for (int i = 0; i < size; ++i)
		delete[] matrix[i];
	delete[] matrix;

	return 0;
}