#pragma once
#include <fstream>
#include "list.h"

struct PhoneBook {
	List phoneList;
};

void add(char name[], int number, PhoneBook &A);

int getNumber(char name[], PhoneBook &A);
char *getName(int number, PhoneBook &A);

void save(std::ofstream &out, PhoneBook &A);

void clear(PhoneBook &A);