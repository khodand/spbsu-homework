#pragma once
#include <fstream>
#include "list.h"

struct phoneBook {
	list phoneList;
};

void add(char name[], int number, phoneBook &A);

int getNumber(char name[], phoneBook &A);
char *getName(int number, phoneBook &A);

void save(std::ofstream &out, phoneBook &A);

void clear(phoneBook &A);