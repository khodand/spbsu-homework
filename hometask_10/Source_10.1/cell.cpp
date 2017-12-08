#include "cell.h"

int getCellNumb(int x, int y, int abscissa) {
	return y * abscissa + x;
}

void relaxDirections(Cell cell, int abscissa, int ordinLenght, Cell *cellArr) {
	int curCell = getCellNumb(cell.x, cell.y, abscissa);
	for (int x = -1; x < 2; ++x) {
		for (int y = -1; y < 2; ++y) {
			if (cell.x + x >= 0 && cell.x + x < abscissa && cell.y + y >= 0 && cell.y + y < ordinLenght) {
				int nextCell = getCellNumb(cell.x + x, cell.y + y, abscissa);
				if (!cellArr[nextCell].isBlocked && cellArr[nextCell].dist > cellArr[curCell].dist + 1) {
					cellArr[nextCell].dist = cellArr[curCell].dist + 1;
					cellArr[nextCell].prev = curCell;
				}
			}
		}
	}
}