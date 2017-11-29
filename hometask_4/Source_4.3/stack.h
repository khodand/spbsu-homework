#pragma once

struct StackElement {
	int value;
	StackElement* next;
};

struct Stack {
	StackElement *top;
};

void createStack(Stack &A);
void clear(Stack &A);

bool isEmpty(Stack &A);

void push(Stack &A, int value);
int pop(Stack &A);

int top(Stack &A);