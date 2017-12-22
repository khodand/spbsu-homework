#pragma once
#include "pair.h"
#include <string>
#include <fstream>
#include <iostream>

const int alphabetLen = 256;

void encode(std::ifstream &in, std::ofstream &out);