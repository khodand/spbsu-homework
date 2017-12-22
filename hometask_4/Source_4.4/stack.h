#pragma once

struct StackElement {
	int value;
	StackElement* next = nullptr;
};

struct Stack {
	StackElement *top = nullptr;
};

void clear(Stack &stack);

bool isEmpty(Stack &stack);

void push(Stack &stack, int value);
int pop(Stack &stack);

int top(Stack &stack);