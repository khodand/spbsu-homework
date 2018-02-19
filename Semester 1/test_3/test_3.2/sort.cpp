#include "sort.h"

void sortByColumn(int **arr, int indexToSort, int size) {
	for (int i = 0; i < size; ++i)
		for (int j = i; j < size; ++j)
			if (arr[j][indexToSort] < arr[i][indexToSort]) {
				int *tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
}