#include "postfixNotation.h"
#include "stack.h"
#include "queue.h"

bool isDigit(char token) {
	return token >= '0' && token <= '9';
}

int calculate(Queue &expression, bool isPostfix) {

	if (!isPostfix)
		expression = toPostfix(expression);

	Stack operands;

	while (!isEmpty(expression)) {
		char curToken = front(expression);

		if (isDigit(curToken)) {
			push(operands, curToken - '0');
			pop(expression);
			continue;
		}

		int newOperand = 0;
		int subtrahend = 0;
		int divisor = 0;
		switch (curToken) {
		case '+':
			newOperand = pop(operands) + pop(operands);
			push(operands, newOperand);
			break;

		case '-':
			subtrahend = pop(operands);
			newOperand = pop(operands) - subtrahend;
			push(operands, newOperand);
			break;

		case '*':
			newOperand = pop(operands) * pop(operands);
			push(operands, newOperand);
			break;

		case '/':
			divisor = pop(operands);
			newOperand = pop(operands) / divisor;
			push(operands, newOperand);
			break;
		}
		pop(expression);
	}

	int result = top(operands);
	clear(expression);
	clear(operands);

	return result;
}

Queue toPostfix(Queue &inStr) {
	Stack operations;
	Queue outStr;


	while (!isEmpty(inStr)) {
		char curToken = front(inStr);
		if (isDigit(curToken)) {
			push(outStr, curToken);
			pop(inStr);
			continue;
		}

		if (isEmpty(operations)) {
			push(operations, curToken);
			pop(inStr);
			continue;
		}

		char last = top(operations);
		switch (curToken) {
		case '+':
		case '-':
			if (last == '(') {
				push(operations, curToken);
				pop(inStr);
			}
			else
				push(outStr, pop(operations));
			break;

		case '*':
		case '/':
			if (last == '(' || last == '+' || last == '-') {
				push(operations, curToken);
				pop(inStr);
			}
			else
				push(outStr, pop(operations));
			break;

		case '(':
			push(operations, curToken);
			pop(inStr);
			break;

		case ')':
			while (top(operations) != '(')
				push(outStr, pop(operations));
			pop(operations);
			pop(inStr);
			break;
		}
	}

	while (!isEmpty(operations))
		push(outStr, pop(operations));

	clear(operations);
	return outStr;
}