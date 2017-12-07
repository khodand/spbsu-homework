#include "stack.h"

const int error = -2147483646;

void createStack(Stack &stack) {
	Stack *newStack = new Stack;
	newStack->top = nullptr;

	stack = *newStack;
	delete newStack;
}

StackElement* createStackElement(int value) {
	StackElement *newStackElement = new StackElement;

	newStackElement->value = value;
	newStackElement->next = nullptr;

	return newStackElement;
}

void clear(Stack &stack) {
	while (!isEmpty(stack))
		pop(stack);
}

bool isEmpty(Stack &stack) {
	return stack.top == nullptr;
}

void push(Stack &stack, int value) {
	StackElement *newStackElement = createStackElement(value);

	newStackElement->next = stack.top;
	stack.top = newStackElement;
}

int pop(Stack &stack) {

	if (isEmpty(stack))
		return error;

	int result = stack.top->value;

	StackElement *tempElement = stack.top;
	stack.top = stack.top->next;
	delete tempElement;

	return result;
}

int top(Stack &stack) {
	if (isEmpty(stack))
		return error;

	return stack.top->value;
}