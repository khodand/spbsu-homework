#pragma once

struct person {
	char *name;
	int number;
};

person *create(char name[], int number);
void deletePerson(person *person);