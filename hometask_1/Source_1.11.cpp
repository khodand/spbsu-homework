#include <iostream>

using namespace std;

void quicksort(int *arr, int l, int r) 
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

		quicksort(arr, l, j);
		quicksort(arr, i, r);
	}
}

int main()
{
	int len = 0;

	cout << "Enter array's length: " << endl;
	cin >> len;

	int *numbers = new int[len];
	
	cout << "Enter array: " << endl;
	for (int i = 0; i < len; ++i) 
		cin >> numbers[i];

	quicksort(numbers, 0, len - 1);

	cout << "Sorted array: " << endl;
	for (int i = 0; i < len; ++i)
		cout << numbers[i] << " ";
	
	delete[] numbers;
	return 0;
}