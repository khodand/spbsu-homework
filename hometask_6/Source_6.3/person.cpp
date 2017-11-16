#include "person.h"

person *create(char name[], int number) {
	person *newPerson = new person;
	newPerson->name = name;
	newPerson->number = number;

	return newPerson;
}

void deletePerson(person *person) {
	delete[] person->name;
	delete person;
}