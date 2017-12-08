#pragma once

const int infimum = 10 * 1000 * 1000;

struct Cell {
	int x;
	int y;

	int dist = infimum;
	int prev = -1;
	bool isUsed = false;
	bool isBlocked = false;
};


int getCellNumb(int x, int y, int abscLenght);
void relaxDirections(Cell cell, int abscLenght, int ordinLenght, Cell *cellArr);