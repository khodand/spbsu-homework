#include "qsort.h"

void qsort(int *arr, int l, int r)
{
	int mid = arr[(l + r) / 2];
	int i = l;
	int j = r;

	while (i <= j)
	{
		while (arr[i] < mid)
			++i;

		while (arr[j] > mid)
			--j;

		if (i <= j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			++i;
			--j;
		}

		qsort(arr, l, j);
		qsort(arr, i, r);
	}
}