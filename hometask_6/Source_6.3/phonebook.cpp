#include "phonebook.h"
#include "person.h"
#include "list.h"

int unsigned const maxNameLenght = 50;

bool isEqual(char *A, char *B) {
	for (int i = 0; i < maxNameLenght; ++i) 
		if (A[i] != B[i])
			return false;
	return true;
}

void add(char name[], int number, PhoneBook &A) {
	add(create(name, number), A.phoneList);
}

int getNumber(char name[], PhoneBook &A) {
	for (int i = 0; i < A.phoneList.size; ++i) {
		Person curPerson = get(i, A.phoneList);

		if (isEqual(curPerson.name, name))
			return curPerson.number;
	}
	return -1;
}

char *getName(int number, PhoneBook &A) {
	for (int i = 0; i < A.phoneList.size; ++i) {
		Person curPerson = get(i, A.phoneList);

		if (curPerson.number == number)
			return curPerson.name;
	}
	return "No such name";
}

void save(std::ofstream &out, PhoneBook &A) {
	out << A.phoneList.size << std::endl;
	for (int i = 0; i < A.phoneList.size; ++i) {
		Person curPerson = get(i, A.phoneList);
		out << curPerson.name << " " << curPerson.number << std::endl;
	}
}

void clear(PhoneBook &A) {
	clear(A.phoneList);
}