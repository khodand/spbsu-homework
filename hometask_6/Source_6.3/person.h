#pragma once

struct Person {
	char *name;
	int number;
};

Person *create(char name[], int number);
void deletePerson(Person *person);