#include "list.h"

listEl *create(wordInfo *word) {
	listEl *newEl = new listEl;
	newEl->word = word;
	newEl->next = nullptr;

	return newEl;
}

bool isWordIn(String text, list &A) {
	for (int i = 0; i < A.size; ++i) {
		wordInfo curWord = get(i, A);
		if (areEqual(text, curWord.text)) {
			setNumber(i, A, curWord.number + 1);
			return true;
		}
	}
	return false;
}

void add(wordInfo *word, list &A) {
	if (isEmpty(A)) {
		A.first = create(word);
		A.last = A.first;
		A.size++;
	}
	else {
		if (!isWordIn(word->text, A)) {
			A.last->next = create(word);
			A.last = A.last->next;
			A.size++;
		}
		else
			delete(word);
	}
}

wordInfo get(int i, list &A) {
	listEl *temp = A.first;
	while (i > 0) {
		temp = temp->next;
		--i;
	}

	return *temp->word;
}

void setNumber(int i, list &A, int number) {
	listEl *temp = A.first;
	while (i > 0) {
		temp = temp->next;
		--i;
	}
	temp->word->number = number;
}

void remove(int i, list &A) {
	if (i == 0) {
		deleteWord(A.first->word);
		A.first = A.first->next;
	}
	else {
		listEl *temp = A.first;
		while (i > 1) {
			temp = temp->next;
			--i;
		}

		deleteWord(temp->next->word);
		temp->next = temp->next->next;
	}
	A.size--;
}

bool isEmpty(list &A) {
	return A.first == nullptr;
}

void clear(list &A) {
	while (!isEmpty(A))
		remove(0, A);
}

int getFrequencyOfWord(String text, list &A) {
	for (int i = 0; i < A.size; ++i) {
		wordInfo curWord = get(i, A);
		if (areEqual(text, curWord.text))
			return curWord.number;
	}
	return 0;
}

int numberOfWords(list &A) {
	int result = 0;
	for (int i = 0; i < A.size; ++i) {
		result += get(i, A).number;
	}

	return result;
}