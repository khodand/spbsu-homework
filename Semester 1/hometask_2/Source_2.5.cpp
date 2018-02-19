#include <iostream>

using namespace std;


void heapify(int *numbers, int liftElement, int len)
{
	int temp = 0;
	while (2 * liftElement + 1 < len)
	{
		temp = 2 * liftElement + 1;

		if ((2 * liftElement + 2 < len) && (numbers[2 * liftElement + 2] >= numbers[temp]))
		{
			temp = 2 * liftElement + 2;
		}

		if (numbers[liftElement] < numbers[temp])
		{
			swap(numbers[liftElement], numbers[temp]);
			liftElement = temp;
		}
		else
			break;

	}
}


void heapMake(int* numbers, int len) {
	for (int i = len - 1; i >= 0; --i)
	{
		heapify(numbers, i, len);
	}
}


void heapSort(int *numbers, int len)
{
	heapMake(numbers, len);

	while (len > 0)
	{
		swap(numbers[0], numbers[len - 1]);
		len--;
		heapify(numbers, 0, len);
	}
}


int main()
{
	int len = 0;

	cout << "Enter array's lens: " << endl;
	cin >> len;

	int *numbers = new int[len];

	cout << "Enter numbers: " << endl;
	for (int i = 0; i < len; ++i)
	{
		cin >> numbers[i];
	}

	heapSort(numbers, len);

	cout << "Sorted array: " << endl;
	for (int i = 0; i < len; ++i)
	{
		cout << numbers[i] << " ";
	}

	delete[] numbers;
	return 0;
}