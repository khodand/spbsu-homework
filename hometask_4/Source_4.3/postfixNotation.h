#pragma once
#include "queue.h"

int calculate(Queue &expression, bool isPostfix = false);

Queue toPostfix(Queue &inStr);