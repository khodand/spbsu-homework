#pragma once
#include "pair.h"
#include <string>
#include <fstream>
#include <iostream>

const int alphabetLen = 256;

Node* encode(std::ifstream &in, std::ofstream &out);
void decode(Node *root, std::ifstream &in, std::ofstream &out);