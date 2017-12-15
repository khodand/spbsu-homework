#include <iostream>
#include "sort.h"

using namespace std;

void resize(int *&arr, int &size) {
	int newSize = size * 2;
	int *resizedArr = new int[newSize];
	for (int i = 0; i < size; ++i) {
		resizedArr[i] = arr[i];
	}

	delete[] arr;

	size = newSize;
	arr = resizedArr;
}

int main() {
	int size = 0;
	int arrayLenght = 1;
	int *numbers = new int[arrayLenght];

	cout << "Enter your values: " << endl;
	cin >> numbers[size];
	while (numbers[size] != 0) {
		size++;
		if (size >= arrayLenght) {
			resize(numbers, arrayLenght);
		}
		cin >> numbers[size];
	}

	sort(numbers, size);

	int numberOfEqual = 1;
	cout << numbers[0];
	for (int i = 1; i < size; ++i) {
		if (numbers[i] == numbers[i - 1]) {
			numberOfEqual++;
		}
		else {
			cout << " number: " << numberOfEqual << endl << numbers[i];
			numberOfEqual = 1;
		}
	}
	cout << " number: " << numberOfEqual;

	delete[] numbers;
	return 0;
}