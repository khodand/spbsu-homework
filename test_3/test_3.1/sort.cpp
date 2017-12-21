#include "sort.h"

void sort(int *arr, int size) {
	for (int i = 0; i < size; ++i)
		for (int j = i; j < size; ++j)
			if (arr[j] < arr[i]) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
}