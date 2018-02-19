#pragma once
#include <fstream>

int unsigned const maxNameLenght = 50;
int unsigned const numberLenght = 10;

char *inputName(std::ifstream &cin);
int inputNumber(std::ifstream &cin);

char *inputName();
int inputNumber();
