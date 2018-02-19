#include <iostream>
#include <fstream>
#include "stack.h"

using namespace std;

const int infimum = 1000 * 1000 * 1000;

int min(int a, int b) {
	return a < b ? a : b;
}

int main() {
	ifstream in("Text.txt");

	int citiesNumber = 0;
	int roadsNumber = 0;
	in >> citiesNumber >> roadsNumber;

	bool *used = new bool[citiesNumber];
	int *dist = new int[citiesNumber + 1];
	int *prev = new int[citiesNumber];
	int **matrix = new int*[citiesNumber];

	for (int i = 0; i < citiesNumber; ++i) {
		prev[i] = i;
		used[i] = false;
		dist[i] = infimum;
		matrix[i] = new int[citiesNumber] {0};
	}
	dist[0] = 0;
	dist[citiesNumber] = infimum;

	int a = 0;
	int b = 0;
	int len = 0;
	for (int i = 0; i < roadsNumber; ++i) {
		in >> a >> b >> len;
		--a;
		--b;
		matrix[a][b] = len;
	}
	
	in.close();

	cout << "Cities in order of capture: " << endl;
	for (int k = 0; k < citiesNumber; ++k) {
		int minDistV = citiesNumber;
		for (int i = 0; i < citiesNumber; ++i) {
			if (!used[i] && dist[i] < dist[minDistV])
				minDistV = i;
		}

		if (minDistV == citiesNumber)
			break;
		used[minDistV] = true;
		cout << minDistV + 1 << " ";

		for (int j = 0; j < citiesNumber; ++j)
			if (matrix[minDistV][j] != 0 && !used[j])
				if (dist[j] > dist[minDistV] + matrix[minDistV][j]) {
					dist[j] = dist[minDistV] + matrix[minDistV][j];
					prev[j] = minDistV;
				}
	}
	cout << endl;

	cout << "Cities = distance from 1, path from 1: " << endl;
	for (int i = 0; i < citiesNumber; ++i) {
		cout << i + 1 << " = " << dist[i] << " path: ";

		Stack path;
		push(path, i);
		for (int j = i; j != 0; j = prev[j]) {
			if (j == prev[j])
				break;
			push(path, prev[j]);
		}

		while (!isEmpty(path))
			cout << pop(path) + 1 << " ";
		cout << endl;
	}

	delete[] prev;
	delete[] dist;
	delete[] used;
	for (int i = 0; i < citiesNumber; ++i)
		delete[] matrix[i];
	delete[] matrix;
	return 0;
}