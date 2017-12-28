#include <iostream>
#include <fstream>
#include "cell.h"

using namespace std;

int heuristicDist(Cell a, Cell b) {
	return a.dist + abs(a.x - b.x) + abs(a.y - b.y);
}

void pathOut(int start, int goal, Cell *cellArr, int **grid, int abscissa, int ordinate) {
	for (int j = goal; j != start; j = cellArr[j].prev) {
		grid[cellArr[j].y][cellArr[j].x] = '*';
		if (j == cellArr[j].prev)
			break;
	}
	grid[cellArr[start].y][cellArr[start].x] = 'A';
	grid[cellArr[goal].y][cellArr[goal].x] = 'B';

	for (int i = 0; i < ordinate; ++i) {
		for (int j = 0; j < abscissa; ++j) {
			if (grid[i][j] > 1)
				cout << (char)grid[i][j];
			else
				cout << grid[i][j];
			cout << ' ';
		}
		cout << endl;
	}
}

bool areCorrect(int start, int goal, Cell *cellArr) {
	return !cellArr[start].isBlocked && !cellArr[goal].isBlocked;
}

int main() {
	ifstream in("Text.txt");

	int abscissa = 0;
	int ordinate = 0;
	in >> abscissa >> ordinate;

	int startX = 0;
	int startY = 0;
	int goalX = 0;
	int goalY = 0;
	cout << "Enter (x, y) of start and (x, y) of goal: " << endl;
	cin >> startX >> startY >> goalX >> goalY;

	int start = getCellNumb(startX - 1, startY - 1, abscissa);
	int goal = getCellNumb(goalX - 1, goalY - 1, abscissa);

	int cellsNumber = abscissa * ordinate;
	Cell *cellArr = new Cell[cellsNumber + 1];
	cellArr[start].dist = 0;

	int **grid = new int*[ordinate];
	for (int i = 0; i < ordinate; ++i)
		grid[i] = new int[abscissa];

	for (int i = 0; i < ordinate; ++i) {
		for (int j = 0; j < abscissa; ++j) {
			int curCell = getCellNumb(j, i, abscissa);
			in >> grid[i][j];
			cellArr[curCell].isBlocked = (bool)grid[i][j];
			cellArr[curCell].x = j;
			cellArr[curCell].y = i;
		}
	}

	in.close();

	for (int k = 0; k < cellsNumber; ++k) {
		int minDistV = cellsNumber;

		for (int i = 0; i < cellsNumber; ++i) {
			int a = heuristicDist(cellArr[i], cellArr[goal]);
			int b = heuristicDist(cellArr[minDistV], cellArr[goal]);
			if (!cellArr[i].isUsed && a < b) {
				minDistV = i;
			}
		}

		if (minDistV == cellsNumber || minDistV == goal)
			break;
		cellArr[minDistV].isUsed = true;

		relaxDirections(cellArr[minDistV], abscissa, ordinate, cellArr);
	}

	if (areCorrect(start, goal, cellArr))
		pathOut(start, goal, cellArr, grid, abscissa, ordinate);
	else
		cout << "Incorrect input (blocked cells)";

	delete[] cellArr;
	for (int i = 0; i < ordinate; ++i)
		delete[] grid[i];
	delete[] grid;
	return 0;
}