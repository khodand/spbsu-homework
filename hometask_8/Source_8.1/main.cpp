#include <iostream>

using namespace std;

void dfs(int v, int **matrix, int *students, int number, int start) {
	students[v] = start;
	for (int i = 0; i < v; ++i) {
		if (matrix[v][i] == 1)
			dfs(i, matrix, students, number, start);
	}
	for (int i = v + 1; i < number; ++i) {
		if (matrix[v][i] == 1)
			dfs(i, matrix, students, number, start);
	}
}

int main() {
	int numberOfStudents = 0;

	cout << "Enter students number: " << endl;
	cin >> numberOfStudents;

	int *students = new int[numberOfStudents];
	int **matrix = new int*[numberOfStudents];
	for (int i = 0; i < numberOfStudents; ++i) {
		students[i] = -1;
		matrix[i] = new int[numberOfStudents]{0};
	}

	cout << "Enter the student number and number which he copied" << endl;
	int a = 0;
	int b = 0;
	for (int i = 0; i < numberOfStudents; ++i) {
		cin >> a >> b;
		a--; b--;
		matrix[b][a] = 1;
	}

	dfs(0, matrix, students, numberOfStudents, 0);
	dfs(1, matrix, students, numberOfStudents, 1);
	dfs(2, matrix, students, numberOfStudents, 2);

	cout << "List of students: " << endl;
	for (int i = 0; i < numberOfStudents; ++i) {
		if (students[i] == -1)
			cout << i + 1 << " " << "to dismiss" << endl;
		else
			cout << i + 1 << " " << students[i] + 1 << endl;
	}

	return 0;
}