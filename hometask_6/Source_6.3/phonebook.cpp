#include "phonebook.h"
#include "person.h"
#include "list.h"

int unsigned const maxNameLenght = 50;

bool isEqual(char *list, char *B) {
	for (int i = 0; i < maxNameLenght; ++i) 
		if (list[i] != B[i])
			return false;
	return true;
}

void add(char name[], int number, PhoneBook &list) {
	add(create(name, number), list.phoneList);
}

int getNumber(char name[], PhoneBook &list) {
	for (int i = 0; i < list.phoneList.size; ++i) {
		Person curPerson = get(i, list.phoneList);

		if (isEqual(curPerson.name, name))
			return curPerson.number;
	}
	return -1;
}

char *getName(int number, PhoneBook &list) {
	for (int i = 0; i < list.phoneList.size; ++i) {
		Person curPerson = get(i, list.phoneList);

		if (curPerson.number == number)
			return curPerson.name;
	}
	return "No such name";
}

void save(std::ofstream &out, PhoneBook &list) {
	out << list.phoneList.size << std::endl;
	for (int i = 0; i < list.phoneList.size; ++i) {
		Person curPerson = get(i, list.phoneList);
		out << curPerson.name << " " << curPerson.number << std::endl;
	}
}

void clear(PhoneBook &list) {
	clear(list.phoneList);
}