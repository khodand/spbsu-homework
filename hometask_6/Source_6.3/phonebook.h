#pragma once
#include <fstream>
#include "list.h"

struct PhoneBook {
	List phoneList;
};

void add(char name[], int number, PhoneBook &list);

int getNumber(char name[], PhoneBook &list);
char *getName(int number, PhoneBook &list);

void save(std::ofstream &out, PhoneBook &list);

void clear(PhoneBook &list);
