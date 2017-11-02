#include <iostream>

using namespace std;

void reverse(int *&arr, int l, int r)
{
	int temp = 0;
	while (l < r) 
	{
		temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		++l;
		--r;
	}
}


int main() 
{
	int m = 0;
	int n = 0;

	cout << "Enter the array's lenght: " << endl; 
	cin >> n;

	int *arr = new int[n];

	cout << "Enter your numbers: " << endl;
	for (int i = 0; i < n; ++i) 
	{
		cin >> arr[i];
	}
	
	cout << "Enter m: " << endl;
	cin >> m;
	
	reverse(arr, 0, m - 1);
	reverse(arr, m, n - 1);
	reverse(arr, 0, n - 1);

	cout << "Result: " << endl;
	for (int i = 0; i < n; ++i)
		cout << arr[i] << " ";

	delete[] arr;
	return 0;
}
