#include "points.h"

void outPoints(int **arr, int m, int n) {
	for (int i = 0; i < n; ++i) {
		sortByColumn(arr, i, m);
		int maxInColumn = m - 1;
		bool isMinInString = true;

		while (arr[maxInColumn][i] == arr[m - 1][i]) {
			for (int k = 0; k < n; ++k)
				if (arr[maxInColumn][i] > arr[maxInColumn][k]) {
					isMinInString = false;
					break;
				}

			if (isMinInString)
				std::cout << "Saddle point: " << arr[maxInColumn][i] << std::endl;

			--maxInColumn;
			isMinInString = true;
		}
	}
}