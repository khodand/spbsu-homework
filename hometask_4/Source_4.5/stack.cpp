#include "stack.h"

const int error = -2147483646;

Stack *createStack() {
	Stack *newStack = new Stack;
	newStack->top = nullptr;
	return newStack;
}

StackElement* createStackElement(int value) {
	StackElement *newStackElement = new StackElement;

	newStackElement->value = value;
	newStackElement->next = nullptr;

	return newStackElement;
}

void clear(Stack &A) {
	while (!isEmpty(A))
		pop(A);
}

bool isEmpty(Stack &A) {
	return A.top == nullptr;
}

void push(Stack &A, int value) {
	StackElement *newStackElement = createStackElement(value);

	newStackElement->next = A.top;
	A.top = newStackElement;
}

int pop(Stack &A) {
	
	if (isEmpty(A))
		return error;

	int result = A.top->value;

	StackElement *tempElement = A.top;
	A.top = A.top->next;
	delete tempElement;

	return result;
}

int top(Stack &A) {
	if (isEmpty(A))
		return error;

	return A.top->value;
}