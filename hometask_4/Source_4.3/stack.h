#pragma once

struct StackElement {
	int value;
	StackElement* next;
};

struct Stack {
	StackElement *top;
};

void createStack(Stack &stack);
void clear(Stack &stack);

bool isEmpty(Stack &stack);

void push(Stack &stack, int value);
int pop(Stack &stack);

int top(Stack &stack);