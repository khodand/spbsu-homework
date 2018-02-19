#include "person.h"

Person *create(char name[], int number) {
	Person *newPerson = new Person;
	newPerson->name = name;
	newPerson->number = number;

	return newPerson;
}

void deletePerson(Person *person) {
	delete[] person->name;
	delete person;
}